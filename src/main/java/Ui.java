public class Ui {

    public void printBye(){
        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }

    public void printWelcome(){
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");
    }

    public void printDone(Task task){
        System.out.println("\t____________________________________________________________");
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t" + task.toString());
        System.out.println("\t____________________________________________________________");
    }

    public void printDelete(Task task) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tNoted. I've removed this task:");
        System.out.println("\t" + task.toString());
    }

    public void printAdd(Task task) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t" + task.toString());
    }

    public void printSize(TaskList taskList){
        System.out.println("\tNow you have " + taskList.getTaskList().size() +" tasks in the list.");
        System.out.println("\t____________________________________________________________");
    }

    public void printTaskList(TaskList taskList){
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHere are the tasks in your list:");
        for(int i = 0; i<taskList.getTaskList().size(); i++){
            System.out.println("\t" + (i+1) + "." + taskList.getTaskList().get(i).toString());
        }
        System.out.println("\t____________________________________________________________");
    }

    public void printFind(StringBuilder foundTasks){
        if(foundTasks.length() == 0){
            System.out.println("\t____________________________________________________________");
            System.out.println("\tNo Results");
            System.out.println("\t____________________________________________________________");
        }else{
            foundTasks.deleteCharAt(foundTasks.length() - 1);
            System.out.println("\t____________________________________________________________");
            System.out.println("\tHere are the matching tasks in your list:");
            System.out.println(foundTasks);  // Output user inputS
            System.out.println("\t____________________________________________________________");
        }
    }
}
