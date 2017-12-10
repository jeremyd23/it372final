package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author Jeremy Daker
 * @version 1.0 30 Oct, 2017
 * TopPane.java
 * Generates the menu buttons for the program.
 */
public class TopPane
{
    private static final int BUTTON_FONT_SIZE = 15;
    private static final int BUTTON_MAX_WIDTH = 138;
    private static final int BUTTON_WIDTH = 60;
    private static final int BUTTON_HEIGHT = 40;
    public static final int MENU_SPACING = 20;
    public static final int MENU_MIN_WIDTH = 150;
    private static final int TITLE_FONT_SIZE = 25;

    private VBox topPane;

    /**
     * Constructs styles the VBox and populates it with menu buttons.
     */
    public TopPane() {
        topPane = new VBox(8);
        topPane.setAlignment(Pos.CENTER);
        topPane.setStyle("-fx-background-color: lightblue");

        HBox menu = new HBox(MENU_SPACING);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(0, 0, 8, 0));

        Button viewButton = createButton("View Log");
        viewButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ScenePane.getInstance().setCenterPane(new LogView().getView());
            }
        });

        Button addButton = createButton("Add Form");
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ScenePane.getInstance().setCenterPane(new AddView().getView());
            }
        });

        menu.getChildren().addAll(viewButton, addButton);

        HBox title = getTitle();

        topPane.getChildren().addAll(title, menu);
    }

    private HBox getTitle()
    {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        Text title = new Text("Change Request Log");
        title.setFont(Font.font("Gill Sans MT", FontWeight.BOLD, TITLE_FONT_SIZE));

        hBox.getChildren().add(title);

        return hBox;
    }

    private Button createButton(String label)
    {
        Button button = new Button(label);

        button.setMaxWidth(BUTTON_MAX_WIDTH);
        button.setMinWidth(BUTTON_WIDTH);
        button.setPrefHeight(BUTTON_HEIGHT);
        button.setFont(Font.font("Gill Sans MT", FontWeight.BOLD, BUTTON_FONT_SIZE));
        button.setTextFill(Color.BLACK);
        button.setStyle("-fx-focus-color: #9b2e03;" + "-fx-faint-focus-color: transparent;");

        return button;
    }

    /**
     * Gets the menu VBox.
     * @return VBox holding the menu content.
     */
    public VBox getMenu()
    {
        return topPane;
    }
}