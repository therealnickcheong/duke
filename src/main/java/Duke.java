import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws DukeException {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";*/

        //System.out.println("Hello from\n" + logo);
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");

        ArrayList<Task> toDoList = new ArrayList<>();
        boolean exitFlag = false;
        while(!exitFlag){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String userCmd = myObj.nextLine();  // Read user input
            try{
                if(userCmd.startsWith(" ")){
                    throw new DukeException("empty task");
                }

                if(userCmd.equals("bye")){
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tBye. Hope to see you again soon!");
                    System.out.println("\t____________________________________________________________");
                    exitFlag = true;
                }else if(userCmd.split(" ")[0].equals("done")){
                    int taskNum = Integer.parseInt(userCmd.substring(userCmd.lastIndexOf(' ') + 1));  ;
                    //System.out.println(taskNum);
                    if(taskNum > toDoList.size()){
                        System.out.println("index out of range");
                    }else{
                        //System.out.println(toDoList.get(taskNum-1).description);
                        toDoList.get(taskNum-1).markAsDone();
                        System.out.println("\t____________________________________________________________");
                        System.out.println("\tNice! I've marked this task as done:");
                        System.out.println("\t" + toDoList.get(taskNum-1).toString());
                        System.out.println("\t____________________________________________________________");
                    }


                }else if(userCmd.equals("list")){
                    //list toDoList
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tHere are the tasks in your list:");
                    for(int i = 0; i<toDoList.size(); i++){
                        System.out.println("\t" + (i+1) + "." + toDoList.get(i).toString());
                    }
                    System.out.println("\t____________________________________________________________");

                }else if(userCmd.split(" ")[0].equals("todo")){
                    if(userCmd.split(" ").length == 1){
                        throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                    }else{
                        String todo = userCmd.split("todo ")[1];
                        ToDo t = new ToDo(todo);
                        toDoList.add(t);
                        System.out.println("\t____________________________________________________________");
                        System.out.println("\tGot it. I've added this task:");
                        System.out.println("\t"+ t.toString());  // Output user inputS
                        System.out.println("\tNow you have " + toDoList.size() +" tasks in the list.");
                        System.out.println("\t____________________________________________________________");
                    }



                }else if(userCmd.split(" ")[0].equals("deadline")){
                    if(userCmd.split(" ").length == 1){
                        throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                    }else{
                        String[] deadline = userCmd.split(" /by ");
                        String by = deadline[1];
                        String desc = deadline[0].substring(9);
                        Deadline t = new Deadline(desc, by);
                        toDoList.add(t);
                        System.out.println("\t____________________________________________________________");
                        System.out.println("\tGot it. I've added this task:");
                        System.out.println("\t"+ t.toString());  // Output user inputS
                        System.out.println("\tNow you have " + toDoList.size() +" tasks in the list.");
                        System.out.println("\t____________________________________________________________");
                    }

                }else if(userCmd.split(" ")[0].equals("event")) {
                    if(userCmd.split(" ").length == 1){
                        throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                    }else{
                        String[] event = userCmd.split(" /at ");
                        String at = event[1];
                        String desc = event[0].substring(6);
                        Event t = new Event(desc, at);
                        toDoList.add(t);
                        System.out.println("\t____________________________________________________________");
                        System.out.println("\tGot it. I've added this task:");
                        System.out.println("\t" + t.toString());  // Output user inputS
                        System.out.println("\tNow you have " + toDoList.size() + " tasks in the list.");
                        System.out.println("\t____________________________________________________________");
                    }

                }else{
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }catch(DukeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
