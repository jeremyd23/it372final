package ui;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class FormButton implements Comparable<FormButton>
{
    public static final int TOP_RIGHT_BOTTOM_LEFT_PADDING = 0;


    private Button button;

    public FormButton(int index)
    {
        String description = Controller.getInstance().getForm(index).getDescription();
        String status = Controller.getInstance().getForm(index).getStatus();

        button = new Button(status + " " + description);
        button.setPadding(new Insets(TOP_RIGHT_BOTTOM_LEFT_PADDING));

        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ScenePane.getInstance().setCenterPane(new FormView(index).getView());
            }
        });
    }

    @Override
    public int compareTo(FormButton o)
    {
        return 0;
    }
}
