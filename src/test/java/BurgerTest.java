import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    @InjectMocks
    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Mock
    private Ingredient mockIngredient3;

    private final int indexToRemove;
    private final List<String> expectedNamesAfterRemoval;
    private final int fromIndex;
    private final int toIndex;
    private final List<String> expectedNamesAfterMove;

    public BurgerTest(int indexToRemove, List<String> expectedNamesAfterRemoval,
                      int fromIndex, int toIndex, List<String> expectedNamesAfterMove) {
        this.indexToRemove = indexToRemove;
        this.expectedNamesAfterRemoval = expectedNamesAfterRemoval;
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
        this.expectedNamesAfterMove = expectedNamesAfterMove;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return BurgerParametrizedTest.getTestData();
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(mockBun.getName()).thenReturn("Bun");
        when(mockBun.getPrice()).thenReturn(2.5f);

        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(0.5f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        when(mockIngredient2.getName()).thenReturn("Cheese");
        when(mockIngredient2.getPrice()).thenReturn(1.5f);
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);

        when(mockIngredient3.getName()).thenReturn("Sauce");
        when(mockIngredient3.getPrice()).thenReturn(1.0f);
        when(mockIngredient3.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(indexToRemove);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(expectedNamesAfterRemoval.size(), ingredients.size());
        for (int i = 0; i < expectedNamesAfterRemoval.size(); i++) {
            assertEquals(expectedNamesAfterRemoval.get(i), ingredients.get(i).getName());
        }
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(fromIndex, toIndex);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(expectedNamesAfterMove.size(), ingredients.size());
        for (int i = 0; i < expectedNamesAfterMove.size(); i++) {
            assertEquals(expectedNamesAfterMove.get(i), ingredients.get(i).getName());
        }
    }

    @Test
    public void testGetPrice() {
        float expectedPrice = getExpectedPrice(mockBun, burger.ingredients);
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = getExpectedReceipt(mockBun, burger.ingredients);
        assertEquals(expectedReceipt, burger.getReceipt());
    }

    public static float getExpectedPrice(Bun bun, List<Ingredient> ingredients) {
        return (float) (2 * bun.getPrice() + ingredients.stream().mapToDouble(Ingredient::getPrice).sum());
    }

    public static String getExpectedReceipt(Bun bun, List<Ingredient> ingredients) {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", getExpectedPrice(bun, ingredients)));
        return receipt.toString();
    }
}
