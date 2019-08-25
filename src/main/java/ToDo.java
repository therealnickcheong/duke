public class ToDo extends Task {

    //protected String by;

    public ToDo(String description) {
        super(description);
        this.taskType = "T";
    }

    public ToDo(String description, boolean isDone) {
        super(description);
        this.taskType = "T";
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "[" + super.getTaskType() + "][" + super.getStatusIcon() + "] " + super.getDescription();
    }
}
