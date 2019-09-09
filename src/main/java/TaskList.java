import java.util.ArrayList;
import java.util.Arrays;

public class TaskList {

    protected ArrayList<Task> tasks;

    TaskList(ArrayList<Task> list) {
        tasks = list;
    }

    public int getSize() { return tasks.size(); }

    public ArrayList<Task> getList() { return tasks; }

    //returns a Task object
    public Task getTaskItem(int index) { return tasks.get(index); }

    //for files
    public String getItemData(int index) { return tasks.get(index).toData(); }

    public String getArrayData() {
        String arrayString = "";
        for (Task task : tasks) {
            arrayString = arrayString + task.toData() + System.lineSeparator();
        }
        arrayString = arrayString.substring(0, arrayString.length() - 1);
        return arrayString;
    }

    public void addItem(Task t) {
        tasks.add(t);
    }

    public void deleteItem(int index) {
        tasks.remove(index);
    }

    public void markItemDone(int index) { tasks.get(index).markAsDone(); }

    public ArrayList<Task> findItem(String phrase) {
        ArrayList<Task> foundItems = new ArrayList<>();
        for (Task t : tasks) {
            String[] words = t.getDescription().split(" ");
            if (Arrays.asList(words).contains(phrase)) {
                foundItems.add(t);
            }
        }
        return foundItems;
    }


}
