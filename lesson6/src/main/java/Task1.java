import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        String fileName = "variant3.txt";
        String filePath = "src/main/java/" + fileName;
        FileInputStream fis;
        try {
            fis = new FileInputStream("wrong/path/to/" + fileName);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
            try {
                fis = new FileInputStream(filePath);
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found even with correct path.");
                return;
            }
        }
        try {
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}