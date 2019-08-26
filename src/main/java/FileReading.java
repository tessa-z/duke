import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading extends FileManagement {

    public ArrayList<Task> ReadFile() {
        File file = new File(FILE_PATH);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            ArrayList<Task> listContent = new ArrayList<>();
            String line = br.readLine();

            while (line != null) {
                String[] data = line.split("\\|");
                if (data[0].equals("T ")) {
                    Todo t = new Todo(data[2], data[1].contains("1"));
                    listContent.add(t);
                } else if (data[0].equals("D ")) {
                    Deadline t = new Deadline(data[2], data[3], data[1].contains("1"));
                    listContent.add(t);
                } else if (data[0].equals("E ")) {
                    Event t = new Event(data[2], data[3], data[1].contains("1"));
                    listContent.add(t);
                }
                line = br.readLine();
            }

            return listContent;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
