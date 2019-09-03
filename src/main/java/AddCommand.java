public class AddCommand extends Command {

    public AddCommand(Task t) {
        task = t;
    }

    @Override
    public void execute(Ui ui, TaskList tasks, Storage storage) {
        //ask ui to print something
        //add task to tasks
        //ask storage to write to file
        tasks.AddItem(task);
        storage.writeFile(task.toData(), true);
        ui.showAdded(task, tasks);
    }



}
