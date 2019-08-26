import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDateTime by;

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
        this.taskType = "D";
    }

    public Deadline(String description, LocalDateTime by, Boolean isDone) {
        super(description);
        this.by = by;
        this.taskType = "D";
        this.isDone = isDone;
    }

    public String getBy() {
        return by.format(DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));
    }

    @Override
    public String toString() {
        return "[" + super.getTaskType() + "][" + super.getStatusIcon() + "] " + super.getDescription() + " (by: " + getBy() + ")";
    }
}
