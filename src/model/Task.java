package model;

import javafx.beans.property.SimpleStringProperty;

public class Task
{
    private SimpleStringProperty title;
    private SimpleStringProperty category;

    public String getTitle()
    {
        return title.get();
    }

    public void setTitle(String title)
    {
        this.title.set(title);
    }

    public String getCategory()
    {
        return category.get();
    }

    public void setCategory(String category)
    {
        this.category.set(category);
    }

    public Task(String title, String category)
    {
        this.title = new SimpleStringProperty(title);
        this.category = new SimpleStringProperty(category);
    }

    //PRIORITIES
    final static int NONE = 0;
    final static int LOW = 1;
    final static int MEDIUM = 2;
    final static int HIGH = 3;

}
