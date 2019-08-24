public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskType;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.taskType = "";
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getTaskType() {
        return taskType; //return tick or X symbols
    }

    //...

    public void markAsDone() {
        this.isDone = true;
    }
}
