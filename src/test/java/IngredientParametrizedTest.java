package praktikum;

import java.util.Arrays;
import java.util.Collection;

public class IngredientParametrizedTest {

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "Lettuce", 0.5f},
                {IngredientType.SAUCE, "Ketchup", 0.3f},
                {IngredientType.FILLING, "Cheese", 1.0f}
        });
    }
}
