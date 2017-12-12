package ui;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class LogView
{
    private VBox logBox;
    private ScrollPane scrollPane;

    public LogView()
    {
        logBox = new VBox();
        logBox.setAlignment(Pos.TOP_CENTER);

        scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setMinHeight(450
        );
        assemble();
    }

    private void assemble()
    {
        VBox forms = Controller.getInstance().getFormButtonBox();

        scrollPane.setContent(forms);

        logBox.getChildren().add(scrollPane);
    }

    public VBox getView()
    {
        return logBox;
    }
}
