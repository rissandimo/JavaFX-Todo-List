package com.rissandimo;

import com.rissandimo.controllers.TaskController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.rissandimo.model.Task;

import java.io.IOException;
import java.time.LocalDate;

public class Main extends Application
{
    private ObservableList<Task> taskObservableList = FXCollections.observableArrayList();

    private Stage primaryStage;

    /**
     * Create a dummy task and add it to the observable list
     */
    public Main()
    {
        taskObservableList.add(new Task("Task 1", "Some data", Task.NO_PRIORITY, LocalDate.of(2018, 2, 4)));
    }

    private ObservableList<Task> getTaskObservableList()
    {
        return taskObservableList;
    }

    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;

        loadMainView();
    }

    /**
     * Load main window
     * Load tasks into table view
     */
    private void loadMainView()
    {
        try
        {
            //set scene
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("ui/tasks.fxml"));
            AnchorPane rootLayout = fxmlLoader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Todo List");
            primaryStage.setScene(scene);
            primaryStage.show();

            TaskController taskController = fxmlLoader.getController();
            taskController.loadData(getTaskObservableList());

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
