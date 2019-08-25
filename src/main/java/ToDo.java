public class ToDo extends Task {

    //protected String by;

    public ToDo(String description) {
        super(description);
        this.taskType = "T";

    }

    @Override
    public String toString() {
        return "[" + super.getTaskType() + "][" + super.getStatusIcon() + "] " + super.getDescription();
    }
}
