import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is the Deadline Class
 * inherits from Task Class
 * Has constructor and methods for the Deadline object
 */

public class Deadline extends Task {

    protected LocalDateTime by;

    /**
     * This constructor "Deadline" is used to construct the Deadline object when its created upon user input of "deadline xxx /by d/M/yyyy HHmm"
     * @param description This is the description of the task that is to be created
     * @param by This is the due date of the deadline
     */

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
        this.taskType = "D";
    }

    /**
     * This constructor "Deadline" is used to construct the Deadline object when its created when retrieving data from Duke.txt
     * @param description This is the description of the task that is to be created
     * @param by This is the due date of the deadline
     * @param isDone This is the completion status of the task
     */

    public Deadline(String description, LocalDateTime by, Boolean isDone) {
        super(description);
        this.by = by;
        this.taskType = "D";
        this.isDone = isDone;
    }

    /**
     * This method "getBy" is used to get the due date of the object
     * @return String This returns the due date of the object
     */

    public String getBy() {
        return by.format(DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));
    }

    /**
     * This method "toString" is used to return the relevant attributes to be printed
     * @return String This returns the relevant attributes to be printed
     */

    @Override
    public String toString() {
        return "[" + super.getTaskType() + "][" + super.getStatusIcon() + "] " + super.getDescription() + " (by: " + getBy() + ")";
    }
}
