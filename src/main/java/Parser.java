/**Creates a Command object after extracting information needed**/
public class Parser {

    public static Command parse(String input) {
        try {
            String[] taskInfo = input.split(" ", 2);
            if (taskInfo[0].equals("bye")) {
                //create an ExitCommand
                return new ExitCommand();
            } else if (taskInfo[0].equals("done")) {
                if ((taskInfo.length < 2) || !(taskInfo[1].trim().length() > 0)) throw new DukeException(DukeException.ErrorType.MISSING_INDEX);
                //create a DoneCommand object
                return new DoneCommand();
            } else if (taskInfo[0].equals("delete")) {
                if ((taskInfo.length < 2) || !(taskInfo[1].trim().length() > 0)) throw new DukeException(DukeException.ErrorType.MISSING_INDEX);
                //create a DeleteCommand
                return new DeleteCommand(Integer.parseInt(taskInfo[1]));
            } else if (taskInfo[0].equals("find")) {
                if ((taskInfo.length < 2) || !(taskInfo[1].trim().length() > 0)) throw new DukeException(DukeException.ErrorType.MISSING_INDEX);
                //create a FindCommand
                return new FindCommand(taskInfo[1]);
            } else if (taskInfo[0].equals("list")) {
                return new ListCommand();
            } else {
                if (taskInfo[0].equals("todo")) {
                    //parse and throw into AddCommand
                    Todo t = new Todo(taskInfo[1]);
                    return new AddCommand(t);
                } else if (taskInfo[0].equals("deadline")) {
                    //parse date
                    String[] dateInfo = parseDate("deadline", taskInfo);
                    Date d = new Date();
                    dateInfo[1] = d.convertDate(dateInfo[1]);
                    //create deadline object
                    Deadline t = new Deadline(dateInfo[0], dateInfo[1]);
                    return new AddCommand(t);
                } else if (taskInfo[0].equals("event")) {
                    String[] dateInfo = parseDate("event", taskInfo);
                    Date d = new Date();
                    dateInfo[1] = d.convertDate(dateInfo[1]);
                    //create event object
                    Event t = new Event(dateInfo[0], dateInfo[1]);
                    return new AddCommand(t);
                } else {
                    try {
                        throw new DukeException(DukeException.ErrorType.COMMAND_INVALID);
                    } catch (DukeException e){
                        e.showError();
                        return new BadCommand();
                    }
                }
            }
        } catch (DukeException e) {
            e.showError();
            return new BadCommand();
        }
    }

    public static String[] parseDate(String type, String[] taskInfo) {
        String[] dateInfo = null;//    public void Exception(DukeException e) {
//
        if (type.equals("deadline")) {
            dateInfo = taskInfo[1].split("/by ");
            //tell AddCommand to go add itself
        } else if (type.equals("event")) {
            dateInfo = taskInfo[1].split("/at ");
            //tell AddCommand to go add itself
        } else {
            //throw some error
        }
        return dateInfo;
    }
}
