import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
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

        //String[] toDoList = {};

        ArrayList<Task> toDoList = new ArrayList<>();
        boolean exitFlag = false;
        while(!exitFlag){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String userCmd = myObj.nextLine();  // Read user input

            if(userCmd.equals("bye")){
                System.out.println("\t____________________________________________________________");
                System.out.println("\tBye. Hope to see you again soon!");
                System.out.println("\t____________________________________________________________");
                exitFlag = true;
            }else if(userCmd.substring(0,4).equals("done")){
                int taskNum = Integer.parseInt(userCmd.substring(userCmd.lastIndexOf(' ') + 1));  ;
                //System.out.println(taskNum);
                if(taskNum > toDoList.size()){
                    System.out.println("index out of range");
                }else{
                    //System.out.println(toDoList.get(taskNum-1).description);
                    toDoList.get(taskNum-1).markAsDone();
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tNice! I've marked this task as done:");
                    System.out.println("\t" + "[" + toDoList.get(taskNum-1).getStatusIcon() + "] " + toDoList.get(taskNum-1).description);
                    System.out.println("\t____________________________________________________________");
                }


            }else if(userCmd.equals("list")){
                //list toDoList
                System.out.println("\t____________________________________________________________");
                System.out.println("\tHere are the tasks in your list:");
                for(int i = 0; i<toDoList.size(); i++){
                    System.out.println("\t" + (i+1) + ".[" + toDoList.get(i).getStatusIcon() + "] " + toDoList.get(i).description);
                }
                System.out.println("\t____________________________________________________________");
            }else{
                Task t = new Task(userCmd);
                toDoList.add(t);
                System.out.println("\t____________________________________________________________");
                System.out.println("\tadded: " + userCmd);  // Output user inputS
                System.out.println("\t____________________________________________________________");
            }

        }

    }
}
