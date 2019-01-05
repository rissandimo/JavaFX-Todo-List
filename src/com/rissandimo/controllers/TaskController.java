package com.rissandimo.controllers;

import com.rissandimo.MainApplication;
import com.rissandimo.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.rissandimo.model.Task;
import java.time.LocalDate;


public class TaskController
{

    @FXML
    private TableView<Task> tableView;

    @FXML
    private TableColumn<Task, String> titleColumn;

    @FXML
    private TableColumn<Task, String> categoryColumn;

    @FXML
    private TableColumn<Task, Integer> priorityColumn;

    @FXML
    private TableColumn<Task, LocalDate> dueDateColumn;

    private MainApplication mainApplication;

    private static final int HIGH_PRIORITY = 3;


    public void giveAccessToTaskController(MainApplication mainApplication)
    {
        this.mainApplication = mainApplication;

        tableView.setItems(mainApplication.getTaskObservableList());
    }


    @FXML
    private void initialize()
    {
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        priorityColumn.setCellValueFactory(cellData -> cellData.getValue().priorityProperty().asObject());
        dueDateColumn.setCellValueFactory(cellData -> cellData.getValue().dueDateProperty());
    }

    @FXML
    private void handleNewTask()
    {
        Task newTask = new Task();

        boolean okClicked = mainApplication.showNewTaskDialog(newTask);
        if(okClicked)
        {
            if(newTask.getPriority() == HIGH_PRIORITY)
            {
                mainApplication.getTasksPriorityList().add(newTask);
                mainApplication.getTaskObservableList().add(newTask);
            }
            else
            {
                mainApplication.getTaskObservableList().add(newTask);
            }
        }
    }

    @FXML
    private void handleEditTask()
    {
        try
        {
            Task selectedTask = tableView.getSelectionModel().getSelectedItem();
            mainApplication.showNewTaskDialog(selectedTask);
        }
        catch(NullPointerException e)
        {
            AlertUtil.showWarning("No task chosen", "Please select a task to edit");
        }
        //TODO - reload table view to show edited task
    }

    @FXML
    private void handleShowDeletedItems()
    {
        tableView.setItems(mainApplication.getTasksDeletedList());
    }

    @FXML
    private void handleShowAllItems()
    {
        tableView.setItems(mainApplication.getTaskObservableList());
    }

    @FXML
    private void handleDelete()
    {
        Task userDeleteItem = tableView.getSelectionModel().getSelectedItem();

        if(userDeleteItem == null)
        {
          AlertUtil.showWarning("Warning", "You must select a task to delete");
        }
        else
        {
            mainApplication.getTasksDeletedList().add(userDeleteItem);
            tableView.getItems().remove(userDeleteItem);
        }
    }

    @FXML
    private void handleShowPriority()
    {
        tableView.setItems(mainApplication.getTasksPriorityList());
    }

}

