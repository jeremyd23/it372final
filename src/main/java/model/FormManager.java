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
        counter = formsMap.size();
    }

    public int addForm(String requestorName, String priority, String description)
    {
        int id = counter + 1;
        Form form = new Form(id, LocalDate.now(), requestorName, priority, description);
        formsMap.put(form.getId(), form);

        counter++;

        return id;
    }

    public void setImpact(int formId, String impact)
    {
        formsMap.get(formId).setImpact(impact);
    }

    public void setEstimatedEffort(int formId, int effort)
    {
        formsMap.get(formId).setEstimatedEffort(effort);
    }

    public void setDate(int formId, Dates dateType, LocalDate date)
    {
        if(dateType == Dates.START)
        {
            formsMap.get(formId).setStart(date);
        }
        else if(dateType == Dates.ACCEPTED)
        {
            formsMap.get(formId).setAccepted(date);
        }
        else if(dateType == Dates.REJECTED)
        {
            formsMap.get(formId).setRejected(date);
        }
        else if(dateType == Dates.COMPLETE)
        {
            formsMap.get(formId).setComplete(date);
        }
    }

    public Form getForm(int id)
    {
        return formsMap.get(id);
    }

    public HashMap<Integer, Form> getForms()
    {
        return formsMap;
    }
}
