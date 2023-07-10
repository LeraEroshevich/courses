import java.util.stream.Stream;

import page.HomePage;
import page.ShowPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class RelaxByTask1Test {

    @RegisterExtension
    static ExecutionModeExtension executionModeExtension = new ExecutionModeExtension();

    @ParameterizedTest
    @ArgumentsSource(ShowTypeProvider.class)
    void checkShowTitleTest(String showType, String expectedTitle) {
        HomePage homePage = new HomePage();
        homePage.openHomePage();

        ShowPage showPage = homePage.selectShowType(showType);

        Assertions.assertTrue(showPage.isTitleVisible(expectedTitle));
    }

    public static class ExecutionModeExtension implements ParameterResolver {
        @Override
        public boolean supportsParameter(ParameterContext parameterContext,
            ExtensionContext extensionContext) throws ParameterResolutionException {
            return parameterContext.getParameter().getType() == ExecutionMode.class;
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext,
            ExtensionContext extensionContext) throws ParameterResolutionException {
            return ExecutionMode.CONCURRENT;
        }

    }
    public static class ShowTypeProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of("Мюзикл", "Мюзикл в Минске"),
                Arguments.of("Балет", "Балет в Минске"),
                Arguments.of("Комедия", "Спектакль-комедия в Минске")
            );
        }
    }
}
