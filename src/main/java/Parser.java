import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *This is the Parser Class
 * Handles user input and executes the corresponding command
 */

public class Parser {


    public boolean exitStatus = false;
    private DataReadWrite SaveFile;
    private TaskList DukeTaskList;
    private Ui taskUi = new Ui();

    /**
     * This Constructor "Parser" instantiates the necessary variables to be used in Class "Parser"
     * @param save This is the first parameter to the Parser Constructor
     * @param taskList This is the second parameter to the Parser Constructor
     */

    public Parser(DataReadWrite save, TaskList taskList){
        this.SaveFile = save;
        this.DukeTaskList = taskList;

    }

    /**
     * This method "parse" is used to execute the correct command based on user input
     * @param userCmd This is the first parameter to the parse method
     */

    public void parse(String userCmd){
        try{
            if(userCmd.startsWith(" ")){
                throw new DukeException("empty task");
            }

            if(userCmd.equals("bye")){
                SaveFile.saveData(DukeTaskList.getTaskList());// Save Data upon exit
                taskUi.printBye();
                this.exitStatus = true;

            }else if(userCmd.split(" ")[0].equals("done")){
                int taskNum = Integer.parseInt(userCmd.substring(userCmd.lastIndexOf(' ') + 1));
                if(taskNum > DukeTaskList.getTaskList().size()){
                    throw new DukeException("Done index out of range");
                }else{
                    DukeTaskList.getTaskList().get(taskNum-1).markAsDone();
                    taskUi.printDone(DukeTaskList.getTaskList().get(taskNum-1));
                }


            }else if(userCmd.split(" ")[0].equals("delete")){
                int taskNum = Integer.parseInt(userCmd.substring(userCmd.lastIndexOf(' ') + 1));
                if(taskNum > DukeTaskList.getTaskList().size()){
                    throw new DukeException("Delete index out of range");
                }else{
                    taskUi.printDelete(DukeTaskList.getTaskList().get(taskNum-1));
                    DukeTaskList.deleteTaskList(taskNum-1);
                    taskUi.printSize(DukeTaskList);
                }


            }else if(userCmd.equals("list")){
                taskUi.printTaskList(DukeTaskList);

            }else if(userCmd.split(" ")[0].equals("todo")){
                if(userCmd.split(" ").length == 1){
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }else{
                    String todo = userCmd.split("todo ")[1];
                    ToDo t = new ToDo(todo);
                    DukeTaskList.addTaskList(t);
                    taskUi.printAdd(t);
                    taskUi.printSize(DukeTaskList);
                }

            }else if(userCmd.split(" ")[0].equals("deadline")){
                if(userCmd.split(" ").length == 1){
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                }else{
                    String[] deadline = userCmd.split(" /by ");
                    String by = deadline[1];
                    String desc = deadline[0].substring(9);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
                    LocalDateTime formattedBy = LocalDateTime.parse(by, formatter);
                    Deadline t = new Deadline(desc, formattedBy);
                    DukeTaskList.addTaskList(t);
                    taskUi.printAdd(t);
                    taskUi.printSize(DukeTaskList);
                }

            }else if(userCmd.split(" ")[0].equals("event")) {
                if(userCmd.split(" ").length == 1){
                    throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                }else{
                    String[] event = userCmd.split(" /at ");
                    String at = event[1];
                    String desc = event[0].substring(6);
                    Event t = new Event(desc, at);
                    DukeTaskList.addTaskList(t);
                    taskUi.printAdd(t);
                    taskUi.printSize(DukeTaskList);
                }

            }else if(userCmd.split(" ")[0].equals("find")){
                if(userCmd.split(" ").length == 1){
                    throw new DukeException("☹ OOPS!!! The description of a find cannot be empty.");
                }else{
                    String find = userCmd.split("find ")[1];
                    StringBuilder foundTasks = new StringBuilder();
                    int findCounter = 0;
                    for(Task task: DukeTaskList.getTaskList()){
                        if(task.getDescription().contains(find)){
                            findCounter++;
                            foundTasks.append("\t").append(findCounter).append(".").append(task.toString()).append("\n");
                        }
                    }
                    taskUi.printFind(foundTasks);
                }

            }else{
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }catch(DukeException | IOException e ){
            System.out.println(e.getMessage());
        }catch(DateTimeParseException e){
            System.out.println("Input of /by has to be in \"dd/MM/yyyy HHmm\" format e.g \"14/03/1997 1159\"");
        }
    }

    /**
     * This method "getExitStatus" is used to end the Duke Program
     * @return boolean This is the exit status of the Duke program
     */

    public boolean getExitStatus(){
        return exitStatus;
    }
}
