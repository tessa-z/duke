public class DeleteCommand extends Command {

    protected int index;

    DeleteCommand(int num) {
        index = num-1;
    }

    @Override
    public void execute(Ui ui, TaskList tasks, Storage storage) {
        //ask ui to print something
        //ask tasks to store the thing in arraylist
        //ask storage to write to file
        ui.showDeleted(tasks.getTaskItem(index));
        storage.deleteItemFromFile(tasks.getItemData(index));
        tasks.deleteItem(index);
    }

}
