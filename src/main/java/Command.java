public abstract class Command {

    public void execute(Ui ui, TaskList tasks, Storage storage) {
        //ask ui to print something
        //ask storage to store the thing into tasks

    }

    public boolean isExit() {
        return false;
    };
}
