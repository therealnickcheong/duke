public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.taskType = "E";
    }

    public Event(String description, String at, Boolean isDone) {
        super(description);
        this.at = at;
        this.taskType = "E";
        this.isDone = isDone;
    }

    public String getAt() {
        return at;
    }
    @Override
    public String toString() {
        return "[" + super.getTaskType() + "][" + super.getStatusIcon() + "] " + super.getDescription() + " (at: " + at + ")";
    }
}
