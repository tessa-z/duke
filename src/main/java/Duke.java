import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Duke\n     What can I do for you?");
        System.out.println("    ____________________________________________________________");


        ArrayList<String> tasks = new ArrayList<String>();

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
                int count = 0;
                for (String task : tasks) {
                    count++;
                    System.out.println("     " + count + ". " + task);
                }
                System.out.println("    ____________________________________________________________");
            } else {
                tasks.add(input);
                System.out.println("    ____________________________________________________________");
                System.out.println("     added: " + input);
                System.out.println("    ____________________________________________________________");
            }
        }

    }
}
