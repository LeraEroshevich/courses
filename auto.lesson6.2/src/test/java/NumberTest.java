import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumberTest {

    @DataProvider(name = "numbers")
    public Object[][] numberDataProvider() {
        return new Object[][] {
            new Object[] {1},
            new Object[] {2},
            new Object[] {3},
            new Object[] {4}
        };
    }

    @Test(dataProvider = "numbers")
    public void testNumberGreaterThanZero(int number) {
        Assert.assertTrue(number > 0, "Number should be greater than 0");
    }
}
