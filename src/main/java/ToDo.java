/**
 * This is the ToDo Class
 * inherits from Task Class
 * Has constructor and methods for the ToDo object
 */

public class ToDo extends Task {

    //protected String by;

    /**
     * This constructor "ToDo" is used to construct the ToDo object when its created upon user input of "todo xxx"
     * @param description This is the description of the task that is to be created
     */


    public ToDo(String description) {
        super(description);
        this.taskType = "T";
    }

    /**
     * This constructor "ToDo" is used to construct the ToDo object when its created when retrieving data from Duke.txt
     * @param description This is the description of the task that is to be created
     * @param isDone This is the completion status of the task
     */

    public ToDo(String description, boolean isDone) {
        super(description);
        this.taskType = "T";
        this.isDone = isDone;
    }

    /**
     * This method "toString" is used to return the relevant attributes to be printed
     * @return String This returns the relevant attributes to be printed
     */

    @Override
    public String toString() {
        return "[" + super.getTaskType() + "][" + super.getStatusIcon() + "] " + super.getDescription();
    }
}
