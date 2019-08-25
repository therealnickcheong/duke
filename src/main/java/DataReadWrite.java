import java.io.*;
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
        //System.out.println(savedTasks);
        //savedTasks.deleteCharAt(savedTasks.length() - 1);
        writeFile(savedTasks.toString());
        System.out.println("Tasks Saved");
    }

    public void writeFile(String tasksToWrite) throws IOException{
        FileWriter fileToWrite = new FileWriter(filepath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileToWrite);
        bufferedWriter.write(tasksToWrite);
        bufferedWriter.close();
    }

    public void readFile() throws IOException{
        FileReader fileToRead = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileToRead);
        String line;
        while((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
