import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Duke\n     What can I do for you?");
        System.out.println("    ____________________________________________________________");

        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equals("bye")) {
                System.out.println("    ____________________________________________________________");
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
                break;
            } else {
                System.out.println("    ____________________________________________________________");
                System.out.println("     " + input);
                System.out.println("    ____________________________________________________________");
            }
        }

    }
}
