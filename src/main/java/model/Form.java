package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Form
{
    //required
    private int id;
    private LocalDate requestDate;
    private String requestorName;
    private String priority;
    private String description;
    private ArrayList<String> editedBy;

    //optional
    private String impact;
    private int estimatedEffort;
    private LocalDate accepted;
    private LocalDate rejected;
    private LocalDate start;
    private LocalDate complete;
    private String status;

    public Form(int id, LocalDate requestDate, String requestorName, String priority, String description)
    {
        this.id = id;
        this.requestDate = requestDate;
        this.requestorName = requestorName;
        this.priority = priority;
        this.description = description;

        impact = "";
        estimatedEffort = 0;

        editedBy = new ArrayList<>();
        editedBy.add(requestorName);

        setStatus();
    }

    private void setStatus()
    {
        if(complete != null)
        {
            status = "DONE";
        }
        else if(accepted != null && rejected != null)
        {
            status = "ACCEPTED";
        }
        else if(accepted != null && rejected != null && start != null)
        {
            status = "IN WORK";
        }
        else if(rejected != null)
        {
            status = "REJECTED";
        }
        else if(start != null)
        {
            status = "IN WORK";
        }
        else if(accepted != null)
        {
            status = "ACCEPTED";
        }
        else
        {
            status = "OPEN";
        }
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public LocalDate getRequestDate()
    {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate)
    {
        this.requestDate = requestDate;
    }

    public String getRequestorName()
    {
        return requestorName;
    }

    public void setRequestorName(String requestorName)
    {
        this.requestorName = requestorName;
    }

    public String getLastEditedBy()
    {
        String name = editedBy.get(editedBy.size() - 1);
        return name;
    }

    public String getPriority()
    {
        return priority;
    }

    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getImpact()
    {
        return impact;
    }

    public void setImpact(String impact)
    {
        this.impact = impact;
    }

    public int getEstimatedEffort()
    {
        return estimatedEffort;
    }

    public void setEstimatedEffort(int estimatedEffort)
    {
        this.estimatedEffort = estimatedEffort;
    }

    public LocalDate getAccepted()
    {
        return accepted;
    }

    public void setAccepted(LocalDate accepted)
    {
        this.accepted = accepted;
        setStatus();
    }

    public LocalDate getRejected()
    {
        return rejected;
    }

    public void setRejected(LocalDate rejected)
    {
        this.rejected = rejected;
        setStatus();
    }

    public LocalDate getStart()
    {
        return start;
    }

    public void setStart(LocalDate start)
    {
        this.start = start;
        setStatus();
    }

    public LocalDate getComplete()
    {
        return complete;
    }

    public void setComplete(LocalDate complete)
    {
        this.complete = complete;
        setStatus();
    }

    public HashMap<Dates, LocalDate> getDates()
    {
        HashMap<Dates, LocalDate> dateAndType = new HashMap<>();

        dateAndType.put(Dates.START, start);
        dateAndType.put(Dates.ACCEPTED, accepted);
        dateAndType.put(Dates.COMPLETE, complete);
        dateAndType.put(Dates.REJECTED, rejected);

        return dateAndType;
    }

    public String getStatus()
    {
        return status;
    }
}
