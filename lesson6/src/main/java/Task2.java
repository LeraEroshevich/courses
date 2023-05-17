import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        String fileName = "task2.txt";
        String filePath = "src/main/java/" + fileName;
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            String text = "Hello java, variant 3";
            byte[] bytes = text.getBytes();
            bos.write(bytes);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

