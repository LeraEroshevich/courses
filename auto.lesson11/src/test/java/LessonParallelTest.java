import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class LessonParallelTest {

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void test1() {
        System.out.println("test 1 started");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void test2() {
        System.out.println("test 2 started");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void test3() {
        System.out.println("test 3 started");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void test4() {
        System.out.println("test 4 started");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void test5() {
        System.out.println("test 5 started");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
