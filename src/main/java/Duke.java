public class Duke {

    public Ui ui;
    public Storage storage;
    public TaskList tasks;


    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.loadFile());
    }

    public void run() {
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            Command c = Parser.parse(fullCommand);
            c.execute(ui, tasks, storage);
            isExit = c.isExit();
        }
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }

//    public static void main(String[] args) {
//            System.out.println("    ____________________________________________________________");
//            System.out.println("     Hello! I'm Duke\n     What can I do for you?");
//            System.out.println("    ____________________________________________________________");
//
//        ArrayList<Task> tasks;
//
//        while (true) {
//            FileReading reader = new FileReading();
//            tasks = reader.ReadFile();
//            Scanner in = new Scanner(System.in);
//            String input = in.nextLine();
//            String[] taskInfo = input.split(" ", 2);
//            if (input.equals("bye")) {
//                System.out.println("    ____________________________________________________________");
//                System.out.println("     Bye. Hope to see you again soon!");
//                System.out.println("    ____________________________________________________________");
//                break;
//            } else if (taskInfo[0].equals("done")) {
//                try {
//                    if ((taskInfo.length < 2) || !(taskInfo[1].trim().length() > 0)) throw new DukeException();
//                    if (Integer.parseInt(taskInfo[1]) > tasks.size()) throw new DukeException();
//                    String oldString = tasks.get(Integer.parseInt(taskInfo[1]) - 1).toData();
//                    tasks.get(Integer.parseInt(taskInfo[1]) - 1).markAsDone();
//                    System.out.println("    ____________________________________________________________");
//                    System.out.println("     Nice! I've marked this task as done:");
//                    System.out.println("       " + tasks.get(Integer.parseInt(taskInfo[1]) - 1).toString());
//                    System.out.println("    ____________________________________________________________");
//                    String newString = tasks.get(Integer.parseInt(taskInfo[1]) - 1).toData();
//                    FileWriting writer = new FileWriting();
//                    writer.AddItemToFile(oldString, newString);
//                } catch (DukeException e) {
//                    System.out.println("    ____________________________________________________________");
//                    e.incompleteFields(DukeException.ErrorType.DONE);
//                    System.out.println("    ____________________________________________________________");
//                }
//            } else if (taskInfo[0].equals("delete")) {
//                try {
//                    if ((taskInfo.length < 2) || !(taskInfo[1].trim().length() > 0)) throw new DukeException();
//                    if (Integer.parseInt(taskInfo[1]) > tasks.size()) throw new DukeException();
//                    String oldString = tasks.get(Integer.parseInt(taskInfo[1]) - 1).toData();
//                    System.out.println("    ____________________________________________________________");
//                    System.out.println("     Noted. I've removed this task:");
//                    System.out.println("       " + tasks.get(Integer.parseInt(taskInfo[1]) - 1).toString());
//                    System.out.println("    ____________________________________________________________");
//                    FileWriting writer = new FileWriting();
//                    writer.RemoveItemFromFile(oldString);
//                } catch (DukeException e) {
//                    System.out.println("    ____________________________________________________________");
//                    e.incompleteFields(DukeException.ErrorType.DELETE);
//                    System.out.println("    ____________________________________________________________");
//                }
//            } else if (taskInfo[0].equals("find")) {
//                try {
//                    if ((taskInfo.length < 2) || !(taskInfo[1].trim().length() > 0)) throw new DukeException();
//                    ArrayList<Task> foundItems = new ArrayList<>();
//                    for (Task t : tasks) {
//                        String[] words = t.getDescription().split(" ");
//                        if (Arrays.asList(words).contains(taskInfo[1])) {
//                            foundItems.add(t);
//                        }
//                    }
//                    if (foundItems.size() > 0) {
//                        System.out.println("    ____________________________________________________________");
//                        System.out.println("     Here are the matching tasks in your list:");
//                        int count = 0;
//                        for (Task task : foundItems) {
//                            count++;
//                            System.out.println("     " + count + ". " + task.toString());
//                        }
//                        System.out.println("    ____________________________________________________________");
//                    } else {
//                        System.out.println("    ____________________________________________________________");
//                        System.out.println("     No task matching description. Try another keyword!");
//                        System.out.println("    ____________________________________________________________");
//                    }
//                } catch (DukeException e) {
//                    System.out.println("    ____________________________________________________________");
//                    e.incompleteFields(DukeException.ErrorType.FIND);
//                    System.out.println("    ____________________________________________________________");
//                }
//            }  else if (taskInfo[0].equals("todo")) {
//                try {
//                    if ((taskInfo.length < 2) || !(taskInfo[1].trim().length() > 0)) throw new DukeException();
//                    Todo t = new Todo(taskInfo[1]);
//                    tasks.add(t);
//                    System.out.println("    ____________________________________________________________");
//                    System.out.println("     Got it. I've added this task:");
//                    System.out.println("       [T][✘] " + taskInfo[1]);
//                    System.out.println("     Now you have " + tasks.size() + " task(s) in the list.");
//                    System.out.println("    ____________________________________________________________");
//                    FileWriting writer = new FileWriting();
//                    writer.WriteFile(t.toData(), true);
//                } catch (DukeException e) {
//                    System.out.println("    ____________________________________________________________");
//                    e.incompleteFields(DukeException.ErrorType.TODO);
//                    System.out.println("    ____________________________________________________________");
//                }
//            } else if (taskInfo[0].equals("deadline")) {
//                try {
//                    if ((taskInfo.length < 2) || !(taskInfo[1].trim().length() > 0)) throw new DukeException();
//                    if (!taskInfo[1].contains("/by")) {
//                        throw new DukeException();
//                    }
//                    String[] dateInfo = taskInfo[1].split("/by ");
//                    if ((dateInfo.length < 2) || (dateInfo[1].equals(" ")) || (dateInfo[0].equals("")))
//                        throw new DukeException();
//                    Date d = new Date();
//                    dateInfo[1] = d.convertDate(dateInfo[1]);
//                    if (dateInfo[1].equals("null")) { throw new DukeException(); }
//                    Deadline t = new Deadline(dateInfo[0], dateInfo[1]);
//                    tasks.add(t);
//                    System.out.println("    ____________________________________________________________");
//                    System.out.println("     Got it. I've added this task:");
//                    System.out.println("       [D][✘] " + dateInfo[0] + "(by: " + dateInfo[1] + ")");
//                    System.out.println("     Now you have " + tasks.size() + " task(s) in the list.");
//                    System.out.println("    ____________________________________________________________");
//                    FileWriting writer = new FileWriting();
//                    writer.WriteFile(t.toData(), true);
//                } catch (DukeException e) {
//                    System.out.println("    ____________________________________________________________");
//                    e.incompleteFields(DukeException.ErrorType.DEADLINE);
//                    System.out.println("    ____________________________________________________________");
//                }
//            } else if (taskInfo[0].equals("event")) {
//                try {
//                    if ((taskInfo.length < 2) || !(taskInfo[1].trim().length() > 0)) throw new DukeException();
//                    if (!taskInfo[1].contains("/at")) throw new DukeException();
//                    String[] dateInfo = taskInfo[1].split("/at ");
//                    if ((dateInfo.length < 2) || (dateInfo[1].equals(" ")) || (dateInfo[0].equals("")))
//                        throw new DukeException();
//                    Date d = new Date();
//                    dateInfo[1] = d.convertDate(dateInfo[1]);
//                    if (dateInfo[1].equals("null")) { throw new DukeException(); }
//                    Event t = new Event(dateInfo[0], dateInfo[1]);
//                    tasks.add(t);
//                    System.out.println("    ____________________________________________________________");
//                    System.out.println("     Got it. I've added this task:");
//                    System.out.println("       [E][✘] " + dateInfo[0] + "(at: " + dateInfo[1] + ")");
//                    System.out.println("     Now you have " + tasks.size() + " task(s) in the list.");
//                    System.out.println("    ____________________________________________________________");
//                    FileWriting writer = new FileWriting();
//                    writer.WriteFile(t.toData(), true);
//                } catch (DukeException e) {
//                    System.out.println("    ____________________________________________________________");
//                    e.incompleteFields(DukeException.ErrorType.EVENT);
//                    System.out.println("    ____________________________________________________________");
//                }
//            } else if (taskInfo[0].equals("list")) {
//                try {
//                    if (tasks.isEmpty()) throw new DukeException();
//                    System.out.println("    ____________________________________________________________");
//                    System.out.println("     Here are the tasks in your list:");
//                    int count = 0;
//                    for (Task task : tasks) {
//                        ++count;
//                        System.out.println("     " + count + "." + task.toString());
//                    }
//                    System.out.println("    ____________________________________________________________");
//                } catch (DukeException e){
//                    System.out.println("    ____________________________________________________________");
//                    e.listEmpty();
//                    System.out.println("    ____________________________________________________________");
//                }
//            } else {
//                try {
//                    throw new DukeException();
//                } catch (DukeException e){
//                    System.out.println("    ____________________________________________________________");
//                    e.invalidCommand();
//                    System.out.println("    ____________________________________________________________");
//                }
//            }
//        }
//
//    }
}

