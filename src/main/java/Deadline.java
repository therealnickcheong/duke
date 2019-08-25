public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.taskType = "D";
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[" + super.getTaskType() + "][" + super.getStatusIcon() + "] " + super.getDescription() + " (by: " + by + ")";
    }
}
