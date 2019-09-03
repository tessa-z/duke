import java.util.ArrayList;

public class Ui {

    Ui() {
        Greet();
    }

    public void Greet() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Duke\n     What can I do for you?");
        System.out.println("    ____________________________________________________________");
    }

    public void GoodBye() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
//        call duke to stop running somehow
    }

    public void Done(Task t) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Nice! I've marked this task as done:");
//        System.out.println("       " + tasks.get(Integer.parseInt(taskInfo[1]) - 1).toString());
        System.out.println("    ____________________________________________________________");
    }

    public void Delete(Task t) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Noted. I've removed this task:");
//        System.out.println("       " + tasks.get(Integer.parseInt(taskInfo[1]) - 1).toString());
        System.out.println("    ____________________________________________________________");

    }

    public void Find(ArrayList<Task> foundItems) {
        if (foundItems.size() > 0) {
            System.out.println("    ____________________________________________________________");
            System.out.println("     Here are the matching tasks in your list:");
            int count = 0;
            for (Task task : foundItems) {
                count++;
                System.out.println("     " + count + ". " + task.toString());
            }
            System.out.println("    ____________________________________________________________");
        } else {
            System.out.println("    ____________________________________________________________");
            System.out.println("     No task matching description. Try another keyword!");
            System.out.println("    ____________________________________________________________");
        }
    }

    public void Todo(Task t) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've added this task:");
//        System.out.println("       [T][✘] " + taskInfo[1]);
//        System.out.println("     Now you have " + tasks.size() + " task(s) in the list.");
        System.out.println("    ____________________________________________________________");
    }

    public void Deadline(Task t) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've added this task:");
//        System.out.println("       [D][✘] " + dateInfo[0] + "(by: " + dateInfo[1] + ")");
//        System.out.println("     Now you have " + tasks.size() + " task(s) in the list.");
        System.out.println("    ____________________________________________________________");
    }

    public void Event(Task t) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've added this task:");
//        System.out.println("       [E][✘] " + dateInfo[0] + "(at: " + dateInfo[1] + ")");
//        System.out.println("     Now you have " + tasks.size() + " task(s) in the list.");
        System.out.println("    ____________________________________________________________");
    }

    public void List(Task t) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Here are the tasks in your list:");
        int count = 0;
//        for (Task task : tasks) {
//            ++count;
//            System.out.println("     " + count + "." + task.toString());
//        }
        System.out.println("    ____________________________________________________________");

    }

//    public void Exception(DukeException e) {
//
//    }
}
