import controllers.TaskController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Task;

import java.io.IOException;

public class Main extends Application
{
    private ObservableList<Task> taskObservableList = FXCollections.observableArrayList();

    private Stage primaryStage;

    private AnchorPane rootLayout;

    public Main()
    {
        taskObservableList.add(new Task("Task 1", "Some data"));
    }

    public ObservableList<Task> getTaskObservableList()
    {
        return taskObservableList;
    }

    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;

        loadMainView();

        loadData();
    }

    public void loadMainView()
    {
        try
        {
            //set scene
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("ui/mainWindow.fxml"));
            rootLayout = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Todo List");
            primaryStage.setScene(scene);
            primaryStage.show();

            // load data
            TaskController taskController = fxmlLoader.getController();
            taskController.loadData(getTaskObservableList());

            }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadData()
    {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/mainWindow.fxml"));
            Parent parent = fxmlLoader.load();

        TaskController taskController = (TaskController) fxmlLoader.getController();
        taskController.loadData(getTaskObservableList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
