package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Task;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskController implements Initializable
{

    public TaskController()
    {
        tasksList.add(new Task("item 1", "Todo soon"));
    }

    public ObservableList<Task> getTasksList()
    {
        return tasksList;
    }

    @FXML
    private TableView<Task> tableView;

    @FXML
    private ObservableList<Task> tasksList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Task, String> titleColumn;

    @FXML
    private TableColumn<Task, String> categoryColumn;

    @FXML
    private void setColumnCellFactories()
    {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        setColumnCellFactories();
        tableView.setItems(tasksList);
    }
}
