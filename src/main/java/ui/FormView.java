package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class FormView
{
    public static final int HIKE_VIEW_PADDING = 20;
    public static final int HIKE_VIEW_MIN_HEIGHT = 405;
    public static final int HIKE_VIEW_SPACING = 10;

    private VBox formView;

    public FormView(int id)
    {
        styleFormBox();
    }

    private void styleFormBox()
    {
        formView = new VBox(HIKE_VIEW_SPACING);
        formView.setPadding(new Insets(HIKE_VIEW_PADDING));
        formView.setAlignment(Pos.TOP_LEFT);
        formView.setMinHeight(HIKE_VIEW_MIN_HEIGHT);
    }

    public VBox getView()
    {
        return formView;
    }
}