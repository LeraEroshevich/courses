public class Task1 extends Thread {
    public Task1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread" + getName() + " (id " + getId() + ") is running");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
