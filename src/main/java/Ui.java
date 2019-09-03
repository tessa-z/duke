import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    public String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void showLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void greet() {
        showLine();
        System.out.println(
                        "     Hello! I'm" + "     ,-.      ,       \n" +
                        "                    |  \\     |       \n" +
                        "                    |  | . . | , ,-. \n" +
                        "                    |  / | | |<  |-' \n" +
                        "                    `-'  `-` ' ` `-' \n" +
                        "                                         What can I do for you?");
        showLine();
    }

    public void goodBye() {
        showLine();
        System.out.println("     Bye. Hope to see you again soon!");
        showLine();
    }

    public void showDone(Task t) {
        showLine();
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("       " + t.toString());
        showLine();
    }

    public void showDeleted(Task t) {
        showLine();
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + t.toString());
        showLine();

    }

    public void showFound(ArrayList<Task> foundItems) {
        showLine();
        if (foundItems.size() > 0) {
            System.out.println("     Here are the matching tasks in your list:");
            int count = 0;
            for (Task task : foundItems) {
                count++;
                System.out.println("     " + count + ". " + task.toString());
            }
        } else {
            System.out.println("     No task matching description. Try another keyword!");
        }
        showLine();
    }

    public void showAdded(Task t, TaskList tasks) {
        showLine();
        System.out.println("     Got it. I've added this task:");
        System.out.println("       " + t.toString());
        System.out.println("     Now you have " + tasks.getSize() + " task(s) in the list.");
        showLine();
    }

    public void showList(TaskList tasks) {
        showLine();
        System.out.println("     Here are the tasks in your list:");
        int count = 0;
        for (Task task : tasks.getList()) {
            ++count;
            System.out.println("     " + count + "." + task.toString());
        }
        showLine();
    }

//    public void Exception(DukeException e) {
//
//    }
}
