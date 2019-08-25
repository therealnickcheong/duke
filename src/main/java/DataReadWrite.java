import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReadWrite {
    public static final String filepath = "data/duke.txt";

    public void saveData(ArrayList<Task> taskList)throws IOException{
        StringBuilder savedTasks = new StringBuilder();
        for(Task task : taskList){
            if(task instanceof ToDo){
                //System.out.println(task.toString());
                savedTasks.append(task.getTaskType()).append(" | ").append(task.getStatusIcon()).append(" | ").append(task.getDescription()).append("\n");
            }else if(task instanceof Deadline){
                //System.out.println(task.toString());
                savedTasks.append(task.getTaskType()).append(" | ").append(task.getStatusIcon()).append(" | ").append(task.getDescription()).append(" | ")
                        .append(((Deadline) task).getBy()).append("\n");
            }else if(task instanceof Event){
                //System.out.println(task.toString());
                savedTasks.append(task.getTaskType()).append(" | ").append(task.getStatusIcon()).append(" | ").append(task.getDescription()).append(" | ")
                        .append(((Event) task).getAt()).append("\n");
            }
        }
        System.out.println(savedTasks);
    }
}
