package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Task;


public class TaskController
{

    @FXML
    private TableView<Task> tableView;

    @FXML
    private TableColumn<Task, String> titleColumn;

    @FXML
    private TableColumn<Task, String> categoryColumn;

    public TaskController()
    {

    }

    public void loadData(ObservableList<Task> observableList)
    {
        tableView.setItems(observableList);
    }

    @FXML
    private void initialize()
    {
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
    }
}
