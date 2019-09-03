import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TaskList {

    protected ArrayList<Task> tasks;

    TaskList() {}

    TaskList(ArrayList<Task> list) {
        tasks = list;
    }

    public void AddItem(Task t) {
        tasks.add(t);
    }

    public void DeleteItem(int index) {
        tasks.remove(index-1);
    }

    public int getSize() { return tasks.size(); }


}
