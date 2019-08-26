public class Task {
    protected String description;
    protected String type;
    protected String date;
    protected boolean isDone;

    public Task(String description, String type) {
        this.description = description;
        this.type = type;
        this.isDone = false;
    }

    public Task(String description, String type, String date) {
        this.description = description;
        this.type = type;
        this.date = date;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
    }

}
