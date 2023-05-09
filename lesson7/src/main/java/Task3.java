import java.util.ArrayList;
import java.util.HashSet;

public class Task3 {
    public static void main(String[] args) {
        String text = "The Java Runtime Environment (JRE) version 8 is what you get when you download Java software from java.com.";
        String[] words = text.split(" ");
        ArrayList<String> wordList = new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        HashSet<String> uniqueWords = new HashSet<String>(wordList);
        System.out.println(uniqueWords);
    }
}
