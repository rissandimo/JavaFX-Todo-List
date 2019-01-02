package com.rissandimo.controllers;

import com.rissandimo.model.Task;
import com.rissandimo.util.AlertUtil;
import com.rissandimo.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewTaskController
{
    @FXML
    private TextField taskNameField;

    @FXML
    private TextField taskCategoryField;

    @FXML
    private TextField taskPriorityField;

    @FXML
    private TextField taskDueDateField;

    private boolean okClicked = false;

    private Task task;

    private Stage taskStage;

    private boolean newTaskIsValid()
    {
        String errorMesssage = "";

        String taskName = taskNameField.getText();
        String taskCategory = taskCategoryField.getText();
        String taskPriority = taskPriorityField.getText();
        String taskDueDate = taskDueDateField.getText();

        if(taskName == null || taskName.length() == 0)
        errorMesssage += "Name is invalid! \n";

        if(taskCategory == null || taskCategory.length() == 0)
            errorMesssage += "Category is invalid! \n";

        if(taskPriority == null || taskPriority.length() == 0)
            errorMesssage += "Priority is invalid! \n";

        if(taskDueDate == null || taskDueDate.length() == 0)
            errorMesssage += "Due date is invalid! \n";

        if (errorMesssage.length() == 0) return true;
        else
        {
            AlertUtil.showError("Invalid fields", "Please make sure all fields are filled out");
            return false;
        }
    }

    @FXML
    private void handleCancel()
    {
        okClicked = false;
    }


    /**
     * Check if user input is valid
     * If valid -> save text input to new task
     * mark ok clicked = true
     * close this stage -> new person is shown
     */
    @FXML
    private void handleOk()
    {
        if(newTaskIsValid())
        {
            task.setTitle(taskNameField.getText());
            task.setCategory(taskCategoryField.getText());
            task.setPriority(Integer.parseInt(taskPriorityField.getText()));
            task.setDueDate(DateUtil.stringDateToLocalDate(taskDueDateField.getText()));

            okClicked = true;

            taskStage.close();
        }
    }

    /**
     * Loads a new or pre-existing task to be edited
     * @param task new or pre-existing task to be displayed
     */
    public void setTaskDetails(Task task)
    {
        this.task = task;

        taskNameField.setText(task.getTitle());
        taskCategoryField.setText(task.getCategory());
        taskPriorityField.setText(Integer.toString(task.getPriority()));
        taskDueDateField.setText(DateUtil.localDatetoStringDate(task.getDueDate()));
    }

    public void getAccessToNewTaskStage(Stage taskStageFromMainApp)
    {
        this.taskStage = taskStageFromMainApp;
    }

    public boolean isOkClicked()
    {
        return okClicked;
    }
}
