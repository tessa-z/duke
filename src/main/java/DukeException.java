public class DukeException extends Exception {

    //if list command but list is empty
    public void listEmpty() {
        System.out.println("     ☹ WOT? Task list is empty. Please input a task before\n       viewing list.");
    }

    //if command is invalid
    public void invalidCommand() {
        System.out.println("     ☹ WOT? I don't understand what you have entered.");
    }

    enum ErrorType {
        DONE,
        TODO,
        DEADLINE,
        EVENT,
        DELETE,
        FIND
    }

    //if incomplete fields for task commands
    public void incompleteFields(ErrorType error) {
        switch(error) {
            case DONE: System.out.println("     ☹ WOT? Expected format: \"done [index of task]\""); break;
            case TODO: System.out.println("     ☹ WOT? Expected format: \"todo [description of task]\""); break;
            case DEADLINE: System.out.println("     ☹ WOT? Expected format: \"deadline [description of task] /by\n      DD/MM/YYYY HHMM\""); break;
            case EVENT: System.out.println("     ☹ WOT? Expected format: \"event [description of event] /at\n      DD/MM/YYYY HHMM"); break;
//            case DELETE:
//            case FIND:
        }
    }

}
