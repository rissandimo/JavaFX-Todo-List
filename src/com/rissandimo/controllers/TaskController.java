package com.rissandimo.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import com.rissandimo.model.Task;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;


public class TaskController
{

    @FXML
    private AnchorPane anchorPane;

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


    public void loadData(ObservableList<Task> observableList)
    {
        tableView.setItems(observableList);
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
        try
        {
            //load new task window
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../ui/newTask.fxml"));
            AnchorPane newTaskScene = fxmlLoader.load();
            //load new stage and set task window in stage

            Stage newTaskStage = new Stage();
            newTaskStage.setScene(new Scene(newTaskScene));
            newTaskStage.setTitle("Add new task");
            newTaskStage.showAndWait();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }
}
