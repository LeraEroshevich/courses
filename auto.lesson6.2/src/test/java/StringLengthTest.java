import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringLengthTest {
    @DataProvider(name = "stringData")
    public Object[][] stringDataProvider() {
        return new Object[][] {
            new Object[] {"tested", "test"},
            new Object[] {"testing", "tester"}
        };
    }

    @Test(dataProvider = "stringData")
    public void testStringLength(String str1, String str2) {
        Assert.assertTrue(str1.length() > str2.length(),
                          "Length of first string should be greater than length of second string");
    }
}
