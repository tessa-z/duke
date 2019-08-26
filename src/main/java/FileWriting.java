import java.io.*;

public class FileWriting extends FileManagement {

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

    public void ModifyFile(String oldString, String newString) {
        File file = new File(FILE_PATH);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String oldContent = "";
            String line = br.readLine();

//            System.out.println(newString);

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = br.readLine();
            }
            oldContent = oldContent.substring(0, oldContent.length() - 1);
//            System.out.println(oldContent);
            String newContent = oldContent.replace(oldString, newString);
//            System.out.println(newContent);
            FileWriting writer = new FileWriting();
            writer.WriteFile(newContent, false);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}