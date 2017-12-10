package ui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Jeremy Daker
 * @version 1.0 30 Oct, 2017
 * ScenePane.java
 * Stores and manages an instance of a BorderPane with access to setting each pane of the BorderPane.
 */
public class ScenePane
{
    private static ScenePane instance;
    private BorderPane borderPane;

    private ScenePane()
    {
        borderPane = new BorderPane();
    }

    /**
     * Instantiates a ScenePane instance if not already started and returns it.
     * @return an instance of ScenePane
     */
    public static ScenePane getInstance()
    {
        if(instance == null)
        {
            instance = new ScenePane();
        }

        return instance;
    }

    /**
     * Gets the BorderPane.
     * @return BorderPane object.
     */
    public BorderPane getBorderPane()
    {
        return borderPane;
    }

    /**
     * Sets the top pane of the BorderPane.
     * @param box Accepts an HBox to assign to the BorderPane.
     */
    public void setTopPane(VBox box)
    {
        borderPane.setTop(box);
    }

    /**
     * Sets the left pane of the BorderPane.
     * @param box Accepts a VBox to assign to the BorderPane.
     */
    public void setLeftPane(VBox box)
    {
        borderPane.setLeft(box);
    }

    /**
     * Sets the center pane of the BorderPane.
     * @param box Accepts a VBox to assign to the BorderPane.
     */
    public void setCenterPane(VBox box)
    {
        borderPane.setCenter(box);
    }

    public void setCenterPane(HBox pane)
    {
        borderPane.setCenter(pane);
    }
}
