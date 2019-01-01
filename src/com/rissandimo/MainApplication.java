package com.rissandimo;

import com.rissandimo.controllers.NewTaskController;
import com.rissandimo.controllers.TaskController;
import com.rissandimo.model.Task;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class MainApplication extends Application
{

    public MainApplication()
    {
        taskObservableList.add(new Task("Task 1", "Some data", Task.NO_PRIORITY, LocalDate.of(2018, 2, 4)));
    }

    private ObservableList<Task> taskObservableList = FXCollections.observableArrayList();


    public ObservableList<Task> getTaskObservableList()
    {
        return taskObservableList;
    }

    private Stage primaryStage;

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
            fxmlLoader.setLocation(MainApplication.class.getResource("ui/tasks.fxml"));
            AnchorPane rootLayout = fxmlLoader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Todo List");
            primaryStage.setScene(scene);
            primaryStage.show();

            TaskController taskController = fxmlLoader.getController();
            taskController.giveAccessToTaskController(this);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
    }

    public boolean showNewTaskDialog(Task task)
    {
        try
        {
            //load new task window
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ui/newTask.fxml"));
            AnchorPane newTaskScene = fxmlLoader.load();

            //load new stage and set task window in stage
            Stage newTaskStage = new Stage();
            newTaskStage.setScene(new Scene(newTaskScene));
            newTaskStage.setTitle("Add new task");

            //get access to new task controller - and load the display for the new task
            NewTaskController newTaskController = fxmlLoader.getController();

            //pass this stage to the controller so the controller can close it when the user clicks ok or cancel
            newTaskController.getAccessToNewTaskStage(newTaskStage);
            newTaskController.setTaskDetails(task);

            newTaskStage.showAndWait();//this needs to be called after we send the task to the window or else it task will be null

            return newTaskController.isOkClicked();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
