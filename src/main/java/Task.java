public class Task {
    protected String description;
    protected String type;
    protected String date;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() { return description; }
    public String getType() { return type; }
    public String getDate() { return date; }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public int getStatus() { return (isDone ? 1 : 0); }

    public void markAsDone() {
        this.isDone = true;
    }

    public String toString() {
        return "[" + getType() + "]" + "[" + getStatusIcon() + "] " + getDescription();
    }

    public String toData() {
        return getType() + " | " + getStatus() + " | " + getDescription();
    }


}
