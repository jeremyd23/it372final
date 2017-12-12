package ui;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Dates;
import model.Form;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;

public class FormView
{
    private static String[] priorities = {"High", "Medium", "Low"};
    private HashMap<Dates, LocalDate> dateAndType;
    private Form form;

    private VBox formView;
    private HBox hBox;
    private GridPane leftPane;
    private GridPane rightPane;
    private Label warning;

    private TextArea description;
    private TextArea impact;
    private ComboBox prioritySelect;
    private ComboBox effortSelect;

    public FormView(int id)
    {
        dateAndType = new HashMap<>();

        styleFormBox();
        updateView(id);
    }

    private void styleFormBox()
    {
        formView = new VBox(10);
        formView.setAlignment(Pos.TOP_CENTER);
        formView.setMinWidth(550);

        hBox = new HBox();
        hBox.setMinWidth(550);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.TOP_CENTER);

        leftPane = new GridPane();
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.setHgap(20);
        leftPane.setVgap(5);

        rightPane = new GridPane();
        rightPane.setAlignment(Pos.TOP_CENTER);
        rightPane.setHgap(20);
        rightPane.setVgap(5);
    }

    private void updateView(int id)
    {
        form = Controller.getInstance().getForm(id);

        setNameField(form.getRequestorName());
        setPriorityField(form.getPriority());
        setDescriptionField(form.getDescription());
        setImpactField(form.getImpact());
        setEstimateField(form.getEstimatedEffort());
        setDateFields(form.getDates());

        hBox.getChildren().addAll(leftPane, rightPane);

        Button submit = getSubmit();

        warning = new Label();

        formView.getChildren().addAll(hBox, submit, warning);
    }

    private void setNameField(String username)
    {
        Label name = new Label("Requestor:  " + username);
        leftPane.add(name, 0, 1, 3, 1);
    }

    private void setPriorityField(String priority)
    {
        prioritySelect = new ComboBox();
        prioritySelect.setPromptText("*Select Priority");

        for(int i = 0; i < priorities.length; i++)
        {
            prioritySelect.getItems().add(priorities[i]);
        }

        //set combobox to priority of form
        prioritySelect.getSelectionModel().select(Arrays.asList(priorities).indexOf(priority));

        rightPane.add(prioritySelect, 3, 1, 3, 1);
    }

    private void setDescriptionField(String formDescription)
    {
        Label descritionLabel = new Label("*Description: ");
        leftPane.add(descritionLabel, 0, 2);

        description = new TextArea(formDescription);
        description.setWrapText(true);
        description.setPrefColumnCount(25);
        description.setPrefRowCount(3);

        leftPane.add(description, 0, 3, 3, 1);
    }

    private void setImpactField(String formImpact)
    {
        Label impactLabel = new Label("Areas Impacted: ");
        leftPane.add(impactLabel, 0, 4);

        impact = new TextArea(formImpact);
        impact.setWrapText(true);
        impact.setPrefColumnCount(25);
        impact.setPrefRowCount(3);
        leftPane.add(impact, 0, 5, 3, 1);
    }

    private void setEstimateField(int formEstimate)
    {
        Label effortLabel = new Label("Estimated Effort: ");
        leftPane.add(effortLabel, 0, 6);

        effortSelect = new ComboBox();
        effortSelect.setPromptText("Effort Level");

        for(int i = 0; i <= 20; i++)
        {
            effortSelect.getItems().add(i);
        }

        //set combobox to priority of form
        effortSelect.getSelectionModel().select(formEstimate);

        leftPane.add(effortSelect, 0, 7);
    }

    private void setDateFields(HashMap<Dates, LocalDate> dates)
    {
        VBox box = new VBox(5);

        for(Dates date : Dates.values())
        {
            Label label = new Label(date.toString() + " Date");
            DatePicker datePicker = setDateField(date, dates.get(date));

            box.getChildren().addAll(label, datePicker);
        }

        rightPane.add(box, 3, 2);
    }

    private DatePicker setDateField(Dates dateType, LocalDate date)
    {
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(date);

        datePicker.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                dateAndType.put(dateType, datePicker.getValue());
            }
        });

        return datePicker;
    }

    public Button getSubmit()
    {
        Button button = new Button("Update");
        button.setPrefHeight(75);
        button.setPrefWidth(125);
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String message = "";

                if(prioritySelect.getValue() != null)
                {
                    if(description.getText().length() > 5)
                    {
                        Controller.getInstance().setDescription(form.getId(), description.getText().toString());
                        Controller.getInstance().setPriority(form.getId(), prioritySelect.getValue().toString());

                        if(dateAndType.size() > 0)
                        {
                            Controller.getInstance().updateDate(form.getId(), dateAndType);
                        }

                        if(impact.getText().length() > 0)
                        {
                            Controller.getInstance().updateImpact(form.getId(), impact.getText());
                        }

                        if(effortSelect.getValue() != null)
                        {
                            System.out.println(effortSelect.getValue().toString());
                            int effort = Integer.parseInt(effortSelect.getValue().toString());
                            Controller.getInstance().updateEffort(form.getId(), effort);
                        }

                        ScenePane.getInstance().setCenterPane(new LogView().getView());
                    }
                    else
                    {
                        message = message + "Please enter a description\n";
                    }
                }
                else
                {
                    message = message + "Please select priority level\n";
                }

                if (message.length() > 0)
                {
                    warning.setText(message);
                }
            }
        });

        return button;
    }

    public VBox getView()
    {
        return formView;
    }
}