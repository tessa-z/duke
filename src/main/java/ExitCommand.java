public class ExitCommand extends Command {

    @Override
    public void execute(Ui ui, TaskList tasks, Storage storage) {
        //ask ui to print something
        //ask tasks to store the thing in arraylist
        //ask storage to write to file
        ui.goodBye();
        isExit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
