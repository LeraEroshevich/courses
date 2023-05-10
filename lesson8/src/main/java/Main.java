import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main task = new Main();
        task.task1();
        task.task2();
        task.task3();
    }

    public void task1() {
        System.out.println("Task 1:");
        Task1 thread = new Task1("MyThread");
        thread.start();
    }

    public void task2() {
        System.out.println("Task 2:");
        Task1[] threads = new Task1[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Task1("MyThread-" + i);
        }
        for (int i = threads.length - 1; i >= 0; i--) {
            threads[i].start();
        }
    }

    public void task3() {
        System.out.println("Task 3:");
        List<Task1> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Task1("MyThread-" + i));
        }
        Collections.reverse(threads);
        for (Task1 thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
