public class Task1 {
    public static void main(String[] args) {
        StringBuilder buffer = new StringBuilder("Java is a programming language and computing platform first released by Sun Microsystems in 1995.");
        buffer.delete(45, 53);
        System.out.println(buffer);
    }
}

