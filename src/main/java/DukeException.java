public class DukeException extends Exception {

    protected ErrorType error;
    protected String errorType;

    enum ErrorType {
        LIST_EMPTY,
        COMMAND_EMPTY,
        COMMAND_INVALID,
        MISSING_INDEX,
        TODO_FORMAT,
        DEADLINE_FORMAT,
        EVENT_FORMAT,
        FIND
    }

    DukeException(ErrorType e) {
        error = e;
    }

    //if incomplete fields for task commands
    public void showError() {
        switch(error) {
            case LIST_EMPTY: System.out.println("     ☹ ERROR: Task list is empty. Please input a task before\n       viewing list."); break;
            case COMMAND_EMPTY: System.out.println("     ☹ ERROR Command cannot be empty, please input a command."); break;
            case COMMAND_INVALID: System.out.println("     ☹ ERROR I don't understand what you have entered."); break;
            case MISSING_INDEX: System.out.println("     ☹ ERROR Missing task index. Please specify the index of the task."); break;
            case TODO_FORMAT: System.out.println("     ☹ ERROR Expected format: \"todo [description of task]\""); break;
            case DEADLINE_FORMAT: System.out.println("     ☹ ERROR Expected format: \"deadline [description of task] /by\n      DD/MM/YYYY HHMM\""); break;
            case EVENT_FORMAT: System.out.println("     ☹ ERROR Expected format: \"event [description of event] /at\n      DD/MM/YYYY HHMM"); break;
        }
    }

//    //if list command but list is empty
//    public void listEmpty() {
//        System.out.println("     ☹ ERROR Task list is empty. Please input a task before\n       viewing list.");
//    }

//    //if command is invalid
//    public void invalidCommand() {
//        System.out.println("     ☹ ERROR I don't understand what you have entered.");
//    }
}
