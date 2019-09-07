import java.util.ArrayList;

/**
 * This is the TaskList Class
 * contains the TaskList for Duke as well as the constructors and methods for TaskList
 */

public class TaskList {

    protected ArrayList<Task> DukeTaskList;

    public TaskList(ArrayList<Task> taskList){
        this.DukeTaskList = taskList;
    }

    public ArrayList<Task> getTaskList(){
        return DukeTaskList;
    }

    public void addTaskList(Task task){
        DukeTaskList.add(task);
    }

    public void deleteTaskList(int i){
        DukeTaskList.remove(i);
    }
}
