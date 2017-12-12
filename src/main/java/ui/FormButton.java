package ui;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import model.Form;

import java.time.LocalDate;

public class FormButton implements Comparable<FormButton>
{
    public static final int TOP_RIGHT_BOTTOM_LEFT_PADDING = 0;


    private Button button;

    public FormButton(int index)
    {
        Form form = Controller.getInstance().getForm(index);
        String description = form.getDescription();

        String status = form.getStatus();
        int id = form.getId();
        LocalDate submittedDate = form.getRequestDate();
        String editedBy = form.getLastEditedBy();

        String idLine = "ID: " + id;
        idLine = String.format("%-120s", idLine);

        String buttonText = idLine + "Submitted: " + submittedDate +
                "\nStatus:  " + status +
                "\nDescription: " + description.substring(0, Math.min(description.length(), 85)) + "..." +
                "\nEdited By: " + editedBy;



        button = new Button(buttonText);
        button.setPadding(new Insets(TOP_RIGHT_BOTTOM_LEFT_PADDING));
        button.setPrefHeight(100);
        button.setPrefWidth(550);

        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ScenePane.getInstance().setCenterPane(new FormView(index).getView());
            }
        });
    }

    public Button getButton()
    {
        return button;
    }

    @Override
    public int compareTo(FormButton o)
    {
        return 0;
    }
}
