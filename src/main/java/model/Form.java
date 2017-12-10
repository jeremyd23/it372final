package model;

import java.time.LocalDate;
import java.util.Date;

public class Form
{
    //required
    private int id;
    private LocalDate requestDate;
    private String requestorName;
    private String priority;
    private String description;

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

        setStatus();
    }

    private void setStatus()
    {
        if(complete != null)
        {
            status = "DONE";
        }
        else if(start != null)
        {
            status = "IN WORK";
        }
        else if(accepted != null && rejected != null)
        {
            status = "ACCEPTED";
        }
        else if(rejected != null)
        {
            status = "REJECTED";
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

    public String getStatus()
    {
        return status;
    }
}
