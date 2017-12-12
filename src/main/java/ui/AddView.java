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

import java.time.LocalDate;
import java.util.HashMap;

public class AddView
{
    private static final String[] priorities = {"High", "Medium", "Low"};
    private HashMap<Dates, LocalDate> dateAndType;
    private VBox viewbox;
    private HBox hBox;
    private GridPane leftPane;
    private GridPane rightPane;
    private TextArea description;
    private String  requestorName;
    private TextArea impact;
    private ComboBox prioritySelect;
    private ComboBox effortSelect;
    private Label warning;

    public AddView()
    {
        dateAndType = new HashMap<>();

        viewbox = new VBox(10);
        viewbox.setAlignment(Pos.TOP_CENTER);
        viewbox.setMinWidth(550);

        hBox = new HBox();
        hBox.setMinWidth(550);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.TOP_CENTER);

        leftPane = new GridPane();
        rightPane = new GridPane();
        requestorName = Controller.getInstance().getUsername();

        updateView();
    }

    public void updateView()
    {
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.setHgap(20);
        leftPane.setVgap(5);

        rightPane.setAlignment(Pos.TOP_CENTER);
        rightPane.setHgap(20);
        rightPane.setVgap(5);

        setNameField();
        setPriorityField();
        setDescriptionField();
        setImpactField();
        setEstimateField();
        setDateFields();

        hBox.getChildren().addAll(leftPane, rightPane);

        Button submit = getSubmit();
        warning = new Label();

        viewbox.getChildren().addAll(hBox, submit, warning);
    }

    private void setNameField()
    {
        Label name = new Label("Requestor:  " + requestorName);
        leftPane.add(name, 0, 1, 3, 1);
    }

    private void setPriorityField()
    {
        prioritySelect = new ComboBox();
        prioritySelect.setPromptText("*Select Priority");

        for(int i = 0; i < priorities.length; i++)
        {
            prioritySelect.getItems().add(priorities[i]);
        }
        rightPane.add(prioritySelect, 3, 1, 3, 1);
    }

    private void setDescriptionField()
    {
        Label descritionLabel = new Label("*Description: ");
        leftPane.add(descritionLabel, 0, 2);

        description = new TextArea();
        description.setWrapText(true);
        description.setPrefColumnCount(25);
        description.setPrefRowCount(3);

        leftPane.add(description, 0, 3, 3, 1);
    }

    private void setImpactField()
    {
        Label impactLabel = new Label("Areas Impacted: ");
        leftPane.add(impactLabel, 0, 4);

        impact = new TextArea();
        impact.setWrapText(true);
        impact.setPrefColumnCount(25);
        impact.setPrefRowCount(3);
        leftPane.add(impact, 0, 5, 3, 1);
    }

    private void setEstimateField()
    {
        Label effortLabel = new Label("Estimated Effort: ");
        leftPane.add(effortLabel, 0, 6);

        effortSelect = new ComboBox();
        effortSelect.setPromptText("Effort Level");

        for(int i = 0; i <= 20; i++)
        {
            effortSelect.getItems().add(i);
        }

        leftPane.add(effortSelect, 0, 7);
    }

    private void setDateFields()
    {
        VBox box = new VBox(5);

        for(Dates date : Dates.values())
        {
            Label label = new Label(date.toString() + " Date");
            DatePicker datePicker = setDateField(date);

            box.getChildren().addAll(label, datePicker);
        }

        rightPane.add(box, 3, 2);
    }

    private DatePicker setDateField(Dates date)
    {
        DatePicker datePicker = new DatePicker();
        setDateAction(datePicker, date);

        if(date == Dates.ACCEPTED)
        {
            dateAndType.put(Dates.ACCEPTED, datePicker.getValue());
        }
        else if(date == Dates.COMPLETE)
        {
            dateAndType.put(Dates.COMPLETE, datePicker.getValue());
        }
        else if(date == Dates.START)
        {
            dateAndType.put(Dates.START, datePicker.getValue());
        }
        else if(date == Dates.REJECTED)
        {
            dateAndType.put(Dates.REJECTED, datePicker.getValue());
        }

        return datePicker;
    }

    private void setDateAction(DatePicker datePicker, Dates date)
    {
        datePicker.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                dateAndType.put(date, datePicker.getValue());
            }
        });
    }

    public Button getSubmit()
    {
        Button button = new Button("Submit");
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
                        int id = Controller.getInstance().addForm(requestorName, prioritySelect.getValue().toString(),
                                description.getText());

                        if(dateAndType.size() > 0)
                        {
                            Controller.getInstance().updateDate(id, dateAndType);
                        }

                        if(impact.getText().length() > 0)
                        {
                            Controller.getInstance().updateImpact(id, impact.getText());
                        }

                        if(effortSelect.getValue() != null)
                        {
                            int effort = Integer.parseInt(effortSelect.getValue().toString());
                            Controller.getInstance().updateEffort(id, effort);
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
        return viewbox;
    }
}
