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
        ArrayList<String> toDoList = new ArrayList<String>();
        boolean exitFlag = false;
        while(!exitFlag){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String userCmd = myObj.nextLine();  // Read user input

            if(userCmd.equals("bye")){
                System.out.println("\t____________________________________________________________");
                System.out.println("\tBye. Hope to see you again soon!");
                System.out.println("\t____________________________________________________________");
                exitFlag = true;
            }else if(userCmd.equals("list")){
                //list toDoList
                System.out.println("\t____________________________________________________________");
                for(int i = 0; i<toDoList.size(); i++){
                    System.out.println("\t" + (i+1) + ". " + toDoList.get(i));
                }
                System.out.println("\t____________________________________________________________");
            }else{
                toDoList.add(userCmd);
                System.out.println("\t____________________________________________________________");
                System.out.println("\tadded: " + userCmd);  // Output user inputS
                System.out.println("\t____________________________________________________________");
            }

        }

    }
}
