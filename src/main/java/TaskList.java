import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskList {

    protected ArrayList<Task> tasks;

    TaskList() {}

    TaskList(ArrayList<Task> list) {
        tasks = list;
    }

    public int getSize() { return tasks.size(); }


    public void AddItem(Task t) {
        tasks.add(t);
    }

    public void DeleteItem(int index) {
        tasks.remove(index-1);
    }

    public ArrayList<Task> FindItem(String phrase) {
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
