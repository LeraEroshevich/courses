import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class Task2 {
    public static void main(String[] args) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("task2.txt")))){
            String text = "Hello java, variant 3";
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            bos.write(bytes);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
