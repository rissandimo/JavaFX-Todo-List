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

public class MainApplication extends Application
{

    private Stage primaryStage;

    private ObservableList<Task> taskObservableList = FXCollections.observableArrayList();

    private ObservableList<Task> tasksDeletedList = FXCollections.observableArrayList();

    private ObservableList<Task> tasksPriorityList = FXCollections.observableArrayList();

    public ObservableList<Task> getTaskObservableList()
    {
        return taskObservableList;
    }

    public ObservableList<Task> getTasksPriorityList()
    {
        return tasksPriorityList;
    }

    public ObservableList<Task> getTasksDeletedList()
    {
        return tasksDeletedList;
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

    /**
     * Loads the newTask window and places it in a new stage
     * Gets the new task info from the user and returns it to the caller in TaskController
     *
     * @param task new task to be sent to NewTaskController
     * @return true if the user click the OK button, false otherwise
     */
    public boolean showNewTaskDialog(Task task)
    {
        try
        {
            //load new task window
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ui/newTask.fxml"));
            AnchorPane newTaskScene = fxmlLoader.load();

            //create a new stage and pass in the task window
            Stage newTaskStage = new Stage();
            newTaskStage.setScene(new Scene(newTaskScene));
            newTaskStage.setTitle("Add new task");

            //get access to new task controller
            NewTaskController newTaskController = fxmlLoader.getController();

            //pass new stage created to the controller so the controller can close it when the user clicks ok or cancel
            newTaskController.getAccessToNewTaskStage(newTaskStage);

            //display new/empty task in text field area
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
