import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ExampleTest {

    public static Stream<String[]> testData() {
        return Stream.of(
            new String[]{"testing", "tested"},
            new String[]{"testeddddd", "testing"}
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testStringLength(String firstValue, String secondValue) {
        Assertions.assertTrue(firstValue.length() > secondValue.length(),
                              "Длинна первого значение набора,больше длины значения второй строки этого же набора");
    }
}