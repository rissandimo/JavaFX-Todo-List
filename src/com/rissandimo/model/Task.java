package com.rissandimo.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Task
{

    //PRIORITIES
    public final static int NO_PRIORITY = 0;
    public final static int LOW_PRIORITY = 1;
    public final static int MEDIUM_PRIORITY = 2;
    public final static int HIGH_PRIORITY = 3;

    private final StringProperty title;
    private final StringProperty category;
    private final IntegerProperty priority;
    private final ObjectProperty<LocalDate> dueDate;


    public Task(String title, String category, int priority, LocalDate dueDate)
    {
        this.title = new SimpleStringProperty(title);
        this.category = new SimpleStringProperty(category);
        this.priority = new SimpleIntegerProperty(priority);
        this.dueDate = new SimpleObjectProperty<>(LocalDate.of(2018, 5, 6));
    }

    public Task()
    {
        this(null, null, 0, null);
    }

    public String getTitle()
    {
        return title.get();
    }

    public StringProperty titleProperty()
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

    public StringProperty categoryProperty()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category.set(category);
    }

    public int getPriority()
    {
        return priority.get();
    }

    public IntegerProperty priorityProperty()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority.set(priority);
    }

    public LocalDate getDueDate()
    {
        return dueDate.get();
    }

    public ObjectProperty<LocalDate> dueDateProperty()
    {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate.set(dueDate);
    }

}
