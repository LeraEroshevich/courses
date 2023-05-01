import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        String fileName = "variant3.txt";
        String filePath = "./" + fileName;

        FileInputStream fis = null;
        BufferedReader reader = null;

        try {
            fis = new FileInputStream("wrong/path/to/" + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            try {
                fis = new FileInputStream(filePath);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found even with correct path.");
                System.exit(0);
            }
        }

        try {
            reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}