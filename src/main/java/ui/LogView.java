package ui;

import controller.Controller;
import javafx.scene.layout.VBox;

public class LogView
{
    private VBox logBox;

    public LogView()
    {
        logBox = new VBox();
        assemble();
    }

    private void assemble()
    {
        VBox hikes = Controller.getInstance().getFormButtonBox();
    }

    public VBox getView()
    {
        return logBox;
    }
}
