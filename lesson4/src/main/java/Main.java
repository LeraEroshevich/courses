public class Main {
    public static void main(String[] args) {
        try {
            // какой-то код
            throw new Task1();
        } catch (Task1 e) {
            System.out.println(e.getMessage());
        }
    }
}
