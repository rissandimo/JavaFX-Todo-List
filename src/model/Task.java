package model;

import javafx.beans.property.SimpleStringProperty;

public class Task
{
    private final SimpleStringProperty title;
    private final SimpleStringProperty category;

    public Task(String title, String category)
    {
        this.title = new SimpleStringProperty(title);
        this.category = new SimpleStringProperty(category);
    }


    public String getTitle()
    {
        return title.get();
    }

    public SimpleStringProperty titleProperty()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title.set(title);
    }

    public String getCategory()
    {
        return category.get();
    }

    public SimpleStringProperty categoryProperty()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category.set(category);
    }

    //PRIORITIES
    final static int NONE = 0;
    final static int LOW = 1;
    final static int MEDIUM = 2;
    final static int HIGH = 3;

}
