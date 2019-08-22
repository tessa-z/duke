import java.util.ArrayList;
//import javafx.util.Pair;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Duke\n     What can I do for you?");
        System.out.println("    ____________________________________________________________");

//        Pair<String, Integer>;
        ArrayList<String[]> tasks = new ArrayList<String[]>();

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
                for (String[] task : tasks) {
                    count++;
                    System.out.println("     " + count + ".[" + task[1] + "] " + task[0]);
                }
                System.out.println("    ____________________________________________________________");
            } else if (input.contains("done")) {
                String complete[] = input.split(" ");
                tasks.get(Integer.parseInt(complete[1])-1)[1] = "✓";
                System.out.println("    ____________________________________________________________");
                System.out.println("     Nice! I've marked this task as done:");
                System.out.println("       [" + tasks.get(Integer.parseInt(complete[1])-1)[1] +  "] " + tasks.get(Integer.parseInt(complete[1])-1)[0]);
                System.out.println("    ____________________________________________________________");
            } else {
                String[] newtask = {input, "✗"};
                tasks.add(newtask);
                System.out.println("    ____________________________________________________________");
                System.out.println("     added: " + input);
                System.out.println("    ____________________________________________________________");
            }
        }

    }
}
