import java.util.concurrent.Exchanger;

public class Task3 {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread messageServiceThread = new Thread(new MessageService(exchanger, "Hello World!"));
        Thread messageClientServiceThread = new Thread(new MessageClientService(exchanger));
        messageServiceThread.start();
        messageClientServiceThread.start();
    }
}
