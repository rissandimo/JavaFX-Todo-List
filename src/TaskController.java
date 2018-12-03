import java.util.LinkedList;

public class TaskController
{
    LinkedList<Task> tasksList = new LinkedList<Task>();

    public void addTask(Task task)
    {
        Task newTask = new Task(task.getTitle(), task.getDescription(), task.getDueDate(), task.getPriority(), task.getCategory());

        tasksList.add(newTask);
    }
}
