public class ListCommand extends Command {

    protected String searchPhrase;

    @Override
    public void execute(Ui ui, TaskList tasks, Storage storage) {
        //ask ui to print something
        //ask tasks to store the thing in arraylist
        //ask storage to write to file

        ui.showList(tasks);
    }
}
