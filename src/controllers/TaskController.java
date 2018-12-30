package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.Task;

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
        //create task window
        Dialog<ButtonType> dialogWindow = new Dialog<>();
        dialogWindow.initOwner(anchorPane.getScene().getWindow());
        dialogWindow.setTitle("Add New Task");

        // create buttons
        dialogWindow.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialogWindow.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        //check which button was chosen
        Optional<ButtonType> choice = dialogWindow.showAndWait();
        if(choice.isPresent() && choice.get() == ButtonType.OK)
        {
            System.out.println("user choose - ok");
        }
        else
            System.out.println("user canceled");
    }
}
