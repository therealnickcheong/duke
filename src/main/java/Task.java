/**
 * This is the Task Class
 * Has constructor and methods for the Task object
 */

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;

    /**
     * This constructor "Task" is used to instantiate the attributes of the Task Object
     * @param description This is the description of the task that is to be created
     */

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.taskType = "";
    }

    /**
     * This method "getStatusIcon" is used to get the tick or cross icon based on if the task is done or not
     * @return String This returns the icon
     */

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * This method "getTaskType" is used to get the taskType of the Task object
     * @return String This returns the TaskType
     */

    public String getTaskType() {
        return taskType;
    }

    /**
     * This method "getDescription" is used to get the description of the Task object
     * @return String This returns the description
     */

    public String getDescription() {
        return description;
    }

    /**
     * This method "markAsDone" is used to mark the Task as done upon completion of the task
     * changes the isDone attribute to true
     */

    public void markAsDone() {
        this.isDone = true;
    }
}
