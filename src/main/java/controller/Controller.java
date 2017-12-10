package controller;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import model.Form;
import model.FormManager;

import java.util.HashMap;

public class Controller
{
    private static Controller instance;
    private static String username;

    private FormManager manager;

    private Controller()
    {
        manager = new FormManager();
        username = "Jeremy Daker";
    }

    public static Controller getInstance()
    {
        if(instance == null)
        {
            instance = new Controller();
        }

        return instance;
    }

    public String addForm()
    {


        return null;
    }

    public Form getForm(int id)
    {
        return manager.getForm(id);
    }

    public HashMap<Integer, Form> getForms()
    {
        return manager.getForms();
    }

    public VBox getFormButtonBox()
    {
        VBox forms = new VBox();
        forms.setAlignment(Pos.TOP_CENTER);



        return forms;
    }

    public void setUsername(String name)
    {
        username = name;
    }

    public String getUsername()
    {
       return username;
    }
}
