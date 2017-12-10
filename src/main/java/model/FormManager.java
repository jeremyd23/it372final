package model;

import java.time.LocalDate;
import java.util.*;

public class FormManager
{
    private HashMap<Integer, Form> formsMap;
    private int counter;

    public FormManager()
    {
        formsMap = new HashMap<>();
        //forms = new ArrayList<>();
        counter = formsMap.size();
    }

    public void addForm(String requestorName, String priority, String description)
    {
        Form form = new Form(counter + 1, LocalDate.now(), requestorName, priority, description);
        //forms.add(form);
        formsMap.put(form.getId(), form);

        counter++;
    }

    public void setImpact(int formId, String impact)
    {
        //forms.get(formId).setImpact(impact);
        formsMap.get(formId).setImpact(impact);
    }

    public void setEstimatedEffort(int formId, int effort)
    {
        //forms.get(formId).setEstimatedEffort(effort);
        formsMap.get(formId).setEstimatedEffort(effort);
    }

    public void setDate(int formId, Dates dateType, LocalDate date)
    {
        if(dateType == Dates.START)
        {
            //forms.get(formId).setStart(date);
            formsMap.get(formId).setStart(date);
        }
        else if(dateType == Dates.ACCEPTED)
        {
            //forms.get(formId).setAccepted(date);
            formsMap.get(formId).setStart(date);
        }
        else if(dateType == Dates.REJECTED)
        {
            //forms.get(formId).setRejected(date);
            formsMap.get(formId).setStart(date);
        }
        else if(dateType == Dates.COMPLETE)
        {
            //forms.get(formId).setComplete(date);
            formsMap.get(formId).setStart(date);
        }
    }

//    public ArrayList<Form> getForms()
//    {
//        return forms;
//    }

    public Form getForm(int id)
    {
        return formsMap.get(id);
    }

    public HashMap<Integer, Form> getForms()
    {
        return formsMap;
    }
}
