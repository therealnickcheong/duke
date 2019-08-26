import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataReadWrite {
    public static final String filepath = "data/duke.txt";
    private ArrayList<Task> savedTaskList = new ArrayList<>();

    public void saveData(ArrayList<Task> taskList)throws IOException{
        StringBuilder savedTasks = new StringBuilder();
        for(Task task : taskList){
            if(task instanceof ToDo){
                //System.out.println(task.toString());
                savedTasks.append(task.getTaskType()).append(" - ").append(task.isDone).append(" - ").append(task.getDescription()).append("\n");
            }else if(task instanceof Deadline){
                //System.out.println(task.toString());
                savedTasks.append(task.getTaskType()).append(" - ").append(task.isDone).append(" - ").append(task.getDescription()).append(" - ")
                        .append(((Deadline) task).getBy()).append("\n");
            }else if(task instanceof Event){
                //System.out.println(task.toString());
                savedTasks.append(task.getTaskType()).append(" - ").append(task.isDone).append(" - ").append(task.getDescription()).append(" - ")
                        .append(((Event) task).getAt()).append("\n");
            }
        }
        //System.out.println(savedTasks);
        //savedTasks.deleteCharAt(savedTasks.length() - 1);
        writeFile(savedTasks.toString());
        System.out.println("\tTasks Saved");
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
            refillTaskList(line);
        }
        bufferedReader.close();
    }

    public void refillTaskList(String line){
        String[] taskProperties = line.split(" - ");
        String taskType = taskProperties[0];
        Boolean taskIsDone = Boolean.parseBoolean(taskProperties[1]);
        String taskDesc = taskProperties[2];
        //System.out.println(taskType[0]);
        if(taskType.equals("T")){
            Task t = new ToDo(taskDesc,taskIsDone);
            savedTaskList.add(t);

        }else if(taskType.equals("D")){
            String taskBy = taskProperties[3];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
            LocalDateTime formattedBy = LocalDateTime.parse(taskBy, formatter);
            Task t = new Deadline(taskDesc, formattedBy, taskIsDone);
            savedTaskList.add(t);

        }else if(taskType.equals("E")){
            String taskAt = taskProperties[3];
            Task t = new Event(taskDesc, taskAt, taskIsDone);
            savedTaskList.add(t);

        }
    }

    public ArrayList<Task> updateDukeTaskList(){
        return savedTaskList;
    }
}
