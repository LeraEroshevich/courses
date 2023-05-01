import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String text = "The Java Plug-in software is a component of the Java Runtime Environment (JRE).";
        Pattern pattern = Pattern.compile("Java Runtime");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
