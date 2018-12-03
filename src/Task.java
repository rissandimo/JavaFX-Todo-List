import java.sql.Date;

public class Task
{
    private String title;
    private String description;
    private Date dueDate;
    private Date StartDate;
    private String category;

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    private int priority;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    public Date getStartDate()
    {
        return StartDate;
    }

    public void setStartDate(Date startDate)
    {
        StartDate = startDate;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public Task(String title, String description, Date dueDate, int priority, String category)
    {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.priority = priority;
    }

    //PRIORITIES
    final static int NONE = 0;
    final static int LOW = 1;
    final static int MEDIUM = 2;
    final static int HIGH = 3;

}
