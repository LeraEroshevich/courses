public class EmployeeThread extends Thread {
    private static ThreadLocal<Thread> threadLocal = new ThreadLocal<>();

    public EmployeeThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        threadLocal.set(Thread.currentThread());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                String.format("current thread with id %s have name %s with value is %s",
                        Thread.currentThread().getId(),
                        Thread.currentThread().getName(),
                        threadLocal.get().getId()));
    }
}