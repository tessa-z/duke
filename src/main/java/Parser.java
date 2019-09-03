/**Creates a Command object after extracting information needed**/
public class Parser {

    public static Command parse(String input) {
        String[] taskInfo = input.split(" ", 2);
        if (taskInfo[0].equals("bye")) {
            //create an ExitCommand
            return new ExitCommand();
        } else if (taskInfo[0].equals("done")) {
            //create a DoneCommand object
            return new DoneCommand();
        } else if (taskInfo[0].equals("delete")) {
            //create a DeleteCommand
            return new DeleteCommand()  ;
        } else if (taskInfo[0].equals("find")) {
            //create a FindCommand
            return new FindCommand(taskInfo[1]);
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
                //throw error cuz command invalid
            }
        }
        return null;
    }

    public static String[] parseDate(String type, String[] taskInfo) {
        String[] dateInfo = null;
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
