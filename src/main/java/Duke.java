import java.util.ArrayList;
//import javafx.util.Pair;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Duke\n     What can I do for you?");
        System.out.println("    ____________________________________________________________");

//        Pair<String, Integer>;
        ArrayList<Task> tasks = new ArrayList<Task>();

        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String taskInfo[] = input.split(" ", 2);
            if (input.equals("bye")) {
                System.out.println("    ____________________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
                break;
            } else if (taskInfo[0].equals("done")) {
                try {
                    if ((taskInfo.length < 2) || (taskInfo[1].equals(""))) {
                        DukeException e = new DukeException();
                        throw e;
                    }
                    tasks.get(Integer.parseInt(taskInfo[1]) - 1).markAsDone();
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       [" + tasks.get(Integer.parseInt(taskInfo[1]) - 1).getStatusIcon() + "] " + tasks.get(Integer.parseInt(taskInfo[1]) - 1).description);
                    System.out.println("    ____________________________________________________________");
                } catch (DukeException e) {
                    System.out.println("    ____________________________________________________________");
                    e.incompleteFields(DukeException.ErrorType.DONE);
                    System.out.println("    ____________________________________________________________");
                }
            } else if (taskInfo[0].equals("todo")) {
                try {
                    if ((taskInfo.length < 2) || (taskInfo[1].equals(""))) {
                        DukeException e = new DukeException();
                        throw e;
                    }
                    Todo t = new Todo(taskInfo[1]);
                    tasks.add(t);
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Got it. I've added this task:");
                    System.out.println("       [T][✘] " + taskInfo[1]);
                    System.out.println("     Now you have " + tasks.size() + " task(s) in the list.");
                    System.out.println("    ____________________________________________________________");
                } catch (DukeException e) {
                    System.out.println("    ____________________________________________________________");
                    e.incompleteFields(DukeException.ErrorType.TODO);
                    System.out.println("    ____________________________________________________________");
                }
            } else if (taskInfo[0].equals("deadline")) {
                String dateInfo[] = taskInfo[1].split("/by");
                try {
                    if ((dateInfo.length < 2) || (dateInfo[1].equals(" "))) {
                        DukeException e = new DukeException();
                        throw e;
                    }
                    Deadline t = new Deadline(dateInfo[0], dateInfo[1]);
                    tasks.add(t);
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Got it. I've added this task:");
                    System.out.println("       [D][✘] " + dateInfo[0] + "(by: " + dateInfo[1] + ")");
                    System.out.println("     Now you have " + tasks.size() + " task(s) in the list.");
                    System.out.println("    ____________________________________________________________");
                } catch (DukeException e) {
                    System.out.println("    ____________________________________________________________");
                    e.incompleteFields(DukeException.ErrorType.DEADLINE);
                    System.out.println("    ____________________________________________________________");
                }
            } else if (taskInfo[0].equals("event")) {
                String dateInfo[] = taskInfo[1].split("/at");
                try {
                    if ((dateInfo.length < 2) || (dateInfo[1].equals(" "))) {
                        DukeException e = new DukeException();
                        throw e;
                    }
                    Event t = new Event(dateInfo[0], dateInfo[1]);
                    tasks.add(t);
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Got it. I've added this task:");
                    System.out.println("       [E][✘] " + dateInfo[0] + "(at: " + dateInfo[1] + ")");
                    System.out.println("     Now you have " + tasks.size() + " task(s) in the list.");
                    System.out.println("    ____________________________________________________________");
                } catch (DukeException e) {
                    System.out.println("    ____________________________________________________________");
                    e.incompleteFields(DukeException.ErrorType.EVENT);
                    System.out.println("    ____________________________________________________________");
                }
            } else if (taskInfo[0].equals("list")) {
                try {
                    if (tasks.isEmpty()) {
                        DukeException e = new DukeException();
                        throw e;
                    }
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     Here are the tasks in your list:");
                    int count = 0;
                    for (Task task : tasks) {
                        ++count;
                        System.out.println("     " + count + "." + task.toString());
                    }
                    System.out.println("    ____________________________________________________________");

                } catch (DukeException e){
                    System.out.println("    ____________________________________________________________");
                    e.listEmpty();
                    System.out.println("    ____________________________________________________________");
                }
            } else {
                try {
                    DukeException e = new DukeException();
                    throw e;
                } catch (DukeException e){
                    System.out.println("    ____________________________________________________________");
                    e.invalidCommand();
                    System.out.println("    ____________________________________________________________");
                }
            }
        }

    }
}


