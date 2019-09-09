import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * This is the DataReadWrite Class
 * Saved data stored in DukeTaskList
 * Retrieves data saved in Duke.txt
 * Repopulates DukeTaskList with data retrieved from Duke.txt
 */

public class DataReadWrite {
    //public static final String filepath = "data/duke.txt";
    public static final String filepath ="C:/Users/Lenovo/Documents/sem1 1920/CS2113T/duke-test/data/duke.txt";
    private ArrayList<Task> savedTaskList = new ArrayList<>();

    /**
     * This method "saveData" is used to read data from DukeTaskList and write it to a StringBuilder
     * Calls method "writeFile" to save the StringBuilder to Duke.txt
     * @param taskList TaskList that stores the tasks of Duke
     * @throws IOException exception thrown when there is an error reading or writing to Duke.txt
     */

    public void saveData(ArrayList<Task> taskList)throws IOException{
        StringBuilder savedTasks = new StringBuilder();
        for(Task task : taskList){
            if(task instanceof ToDo){
                //System.out.println(task.toString());
                savedTasks.append(task.getTaskType()).append(" - ").append(task.isDone).append(" - ").append(task.getDescription()).append("\r\n");
            }else if(task instanceof Deadline){
                //System.out.println(task.toString());
                savedTasks.append(task.getTaskType()).append(" - ").append(task.isDone).append(" - ").append(task.getDescription()).append(" - ")
                        .append(((Deadline) task).getBy()).append("\r\n");
            }else if(task instanceof Event){
                //System.out.println(task.toString());
                savedTasks.append(task.getTaskType()).append(" - ").append(task.isDone).append(" - ").append(task.getDescription()).append(" - ")
                        .append(((Event) task).getAt()).append("\r\n");
            }
        }
        //System.out.println(savedTasks);
        savedTasks.deleteCharAt(savedTasks.length() - 1);
        writeFile(savedTasks.toString());
        System.out.println("\tTasks Saved");
    }

    /**
     * This method "writeFile" is used to write a String to Duke.txt
     * @param tasksToWrite StringBuilder that is to be written into Duke.txt
     * @throws IOException exception thrown when there is an error reading or writing to Duke.txt
     */

    public void writeFile(String tasksToWrite) throws IOException{
        FileWriter fileToWrite = new FileWriter(filepath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileToWrite);
        bufferedWriter.write(tasksToWrite);
        bufferedWriter.close();
    }

    /**
     * This method "readFile" is used to read data from Duke.txt
     * Calls method refillTaskList to Repopulate savedTaskList with data from Duke.txt
     * @throws IOException exception thrown when there is an error reading or writing to Duke.txt
     */

    public void readFile() throws IOException{
        FileReader fileToRead = new FileReader(filepath);
        BufferedReader bufferedReader = new BufferedReader(fileToRead);
        String line;
        while((line = bufferedReader.readLine())!=null){
            refillTaskList(line);
        }
        bufferedReader.close();
    }

    /**
     * This method "refillTaskList" is used to identify the Task type of the string, create the corresponding object
     * and repopulate savedTaskList with the created object
     * @param line This is the first parameter to the refillTaskList method
     */

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

    /**
     * This method "updateDukeTaskList" is used to clone objects from savedTaskList to DukeTaskList
     * @return ArrayList<Task> This is the ArrayList of objects to be cloned to DukeTaskList
     */

    public ArrayList<Task> updateDukeTaskList(){
        return savedTaskList;
    }
}
