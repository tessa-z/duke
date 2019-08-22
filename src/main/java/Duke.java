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
            if (input.equals("bye")) {
                System.out.println("    ____________________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
                break;
            } else if (input.equals("list") && (tasks.isEmpty())) {
                System.out.println("    ____________________________________________________________");
                System.out.println("     Task list is empty.");
                System.out.println("    ____________________________________________________________");
            } else if (input.equals("list")) {
                System.out.println("    ____________________________________________________________");
                System.out.println("     Here are the tasks in your list:");
                int count = 0;
                for (Task task : tasks) {
                    count++;
                    System.out.println("     " + count + ".[" + task.getStatusIcon() + "] " + task.description);
                }
                System.out.println("    ____________________________________________________________");
            } else if (input.contains("done")) {
                String complete[] = input.split(" ");
                tasks.get(Integer.parseInt(complete[1]) - 1).markAsDone();
                System.out.println("    ____________________________________________________________");
                System.out.println("     Nice! I've marked this task as done:");
                System.out.println("       [" + tasks.get(Integer.parseInt(complete[1]) - 1).getStatusIcon() + "] " + tasks.get(Integer.parseInt(complete[1]) - 1).description);
                System.out.println("    ____________________________________________________________");
            } else {
                Task t = new Task(input);
                tasks.add(t);
                System.out.println("    ____________________________________________________________");
                System.out.println("     added: " + input);
                System.out.println("    ____________________________________________________________");
            }
        }

    }
}


