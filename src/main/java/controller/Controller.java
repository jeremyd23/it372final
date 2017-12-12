package controller;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import model.Dates;
import model.Form;
import model.FormManager;
import ui.FormButton;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

    public int addForm(String username, String priority, String description)
    {
        int formId = manager.addForm(username, priority, description);

        return formId;
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
        VBox formsBox = new VBox();
        formsBox.setAlignment(Pos.TOP_CENTER);

        HashMap<Integer, Form> forms = manager.getForms();

        for(Map.Entry form : forms.entrySet())
        {
            FormButton button = new FormButton((int)form.getKey());
            formsBox.getChildren().add(button.getButton());
        }

        return formsBox;
    }

    public void setUsername(String name)
    {
        username = name;
    }

    public String getUsername()
    {
       return username;
    }

    public void setDescription(int id, String description)
    {
        manager.getForm(id).setDescription(description);
    }

    public void setPriority(int id, String priority)
    {
        manager.getForm(id).setPriority(priority);
    }

    public void updateDate(int id, HashMap<Dates, LocalDate> dateAndType)
    {
        for(Map.Entry date : dateAndType.entrySet())
        {
            manager.setDate(id, (Dates)date.getKey(), (LocalDate)date.getValue());
        }
    }

    public void updateImpact(int id, String impact)
    {
        manager.setImpact(id, impact);
    }

    public void updateEffort(int id, int effort)
    {
        manager.setEstimatedEffort(id, effort);
    }
}