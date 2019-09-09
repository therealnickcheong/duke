/**
 * This is the Event Class
 * inherits from Task Class
 * Has constructor and methods for the Event object
 */

public class Event extends Task {

    protected String at;

    /**
     * This constructor "Event" is used to construct the Event object when its created upon user input of "event xxx /at xxx"
     * @param description This is the first parameter to the Event constructor
     * @param at This is the second parameter to the Event constructor
     */

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.taskType = "E";
    }

    /**
     * This constructor "Event" is used to construct the Event object when its created when retrieving data from Duke.txt
     * @param description This is the description of the task that is to be created
     * @param at This is the date the event is taking place
     * @param isDone This is the completion status of the task
     */

    public Event(String description, String at, Boolean isDone) {
        super(description);
        this.at = at;
        this.taskType = "E";
        this.isDone = isDone;
    }

    /**
     * This method "getAt" is used to get the details of the event appointment
     * @return String This returns the details of the event appointment
     */

    public String getAt() {
        return at;
    }

    /**
     * This method "toString" is used to return the relevant attributes to be printed
     * @return String This returns the relevant attributes to be printed
     */

    @Override
    public String toString() {
        return "[" + super.getTaskType() + "][" + super.getStatusIcon() + "] " + super.getDescription() + " (at: " + at + ")";
    }
}
