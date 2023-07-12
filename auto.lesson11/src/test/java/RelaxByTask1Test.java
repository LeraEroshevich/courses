import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import page.HomePage;
import page.ShowPage;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Execution(ExecutionMode.CONCURRENT)
public class RelaxByTask1Test {

    @ParameterizedTest
    @MethodSource("showTypesProvider")
    void checkShowTitleTest(String showType, String expectedTitle) {
        ShowPage showPage = new HomePage()
            .openHomePage()
            .getHeader()
            .clickPosterItem()
            .clickSpectaclesItem();

        showPage.clickShowTypeItem(showType);

        assertTrue(showPage.isTitleVisible(expectedTitle));
    }

    private static Stream<Arguments> showTypesProvider() {
        return Stream.of(
            Arguments.of("Мюзикл", "Мюзикл в Минске"),
            Arguments.of("Балет", "Балет в Минске"),
            Arguments.of("Комедия", "Спектакль-комедия в Минске")
        );
    }
}
