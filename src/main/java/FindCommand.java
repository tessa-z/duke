import java.util.ArrayList;

public class FindCommand extends Command {

    protected String searchPhrase;

    FindCommand(String query) {
        searchPhrase = query;
    }

    @Override
    public void execute(Ui ui, TaskList tasks, Storage storage) {
        //ask ui to print something
        //ask tasks to store the thing in arraylist
        //ask storage to write to file

        ArrayList<Task> foundItems = tasks.FindItem(searchPhrase);
        ui.find(foundItems);
    }
}
