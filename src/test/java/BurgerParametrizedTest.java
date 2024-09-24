import java.util.Arrays;
import java.util.List;

public class BurgerParametrizedTest {

    public static List<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {1, Arrays.asList("Lettuce", "Sauce"), 2, 0, Arrays.asList("Sauce", "Lettuce", "Cheese")},
                {0, Arrays.asList("Cheese", "Sauce"), 1, 2, Arrays.asList("Lettuce", "Sauce", "Cheese")}
        });
    }
}