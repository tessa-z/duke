import java.io.*;
import java.util.ArrayList;

public class Storage {

    private static String FILE_PATH = "/home/tessa/Documents/CS2113/duke/data/duke.txt";

    Storage(String filePath) {
        FILE_PATH = filePath;
    }

    public ArrayList<Task> LoadFile() {
        File file = new File(FILE_PATH);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            ArrayList<Task> listContent = new ArrayList<>();
            String line = br.readLine();

            while (line != null) {
                String[] data = line.split("\\| ");
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
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void WriteFile(String s, boolean append) {
        File file = new File(FILE_PATH);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file, append);
            bw = new BufferedWriter(fw);
            bw.write(s);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void FindItemInFile(String searchPhrase) {
        ArrayList<Task> foundItems = new ArrayList<>();
//        for (Task t : tasks) {
//            String[] words = t.getDescription().split(" ");
//            if (Arrays.asList(words).contains(taskInfo[1])) {
//                foundItems.add(t);
//            }
//        }

    }

//    public void AddItemToFile(String oldString, String newString) {
//        File file = new File(Storage.FILE_PATH);
//        FileReader fr = null;
//        BufferedReader br = null;
//        try {
//            fr = new FileReader(file);
//            br = new BufferedReader(fr);
//            String oldContent = "";
//            String line = br.readLine();
//
//            while (line != null) {
//                oldContent = oldContent + line + System.lineSeparator();
//                line = br.readLine();
//            }
//            oldContent = oldContent.substring(0, oldContent.length() - 1);
//            String newContent = oldContent.replace(oldString, newString);
//            FileWriting writer = new FileWriting();
//            writer.WriteFile(newContent, false);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                br.close();
//                fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void DeleteItemFromFile(String oldString) {
//        File file = new File(Storage.FILE_PATH);
//        FileReader fr = null;
//        BufferedReader br = null;
//        try {
//            fr = new FileReader(file);
//            br = new BufferedReader(fr);
//            String oldContent = "";
//            String line = br.readLine();
//
//
//            while (line != null) {
//                oldContent = oldContent + line + System.lineSeparator();
//                line = br.readLine();
//            }
//            oldContent = oldContent.substring(0, oldContent.length() - 1);
//            String newContent = oldContent.replace(oldString, "");
//            FileWriting writer = new FileWriting();
//            writer.WriteFile(newContent, false);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                br.close();
//                fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }



}
