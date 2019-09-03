import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TaskList {

    public ArrayList<Task> tasks;

    TaskList(ArrayList<Task> list) {
        tasks = list;
    }

    public void AddItem(Task t) {
        tasks.add(t);
    }

    public void DeleteItem(int index) {
        tasks.remove(index-1);
    }


}
