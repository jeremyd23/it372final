package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChangeRequestUI extends Application
{
    public static final int SCENE_WIDTH = 550;
    public static final int SCENE_HEIGHT = 550;

    @Override
    public void start(Stage stage)
    {
        Scene scene = assemble();
        stage.setTitle("The Beaten Path");
        stage.setScene(scene);
        stage.show();
    }

    private Scene assemble()
    {
        VBox menu = new TopPane().getMenu();
        ScenePane.getInstance().setTopPane(menu);

        return new Scene(ScenePane.getInstance().getBorderPane(), SCENE_WIDTH, SCENE_HEIGHT);
    }
}
