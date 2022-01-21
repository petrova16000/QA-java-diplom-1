package praktikum.ingredientTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setIngredient(){
        ingredient = new Ingredient(ingredientType, "test", 19);
    }

    @Mock
    IngredientType ingredientType;

    @Test
    public void getPrice() {
        Assert.assertEquals(ingredient.getPrice(), 19, 0);
    }

    @Test
    public void getName() {
        Assert.assertEquals(ingredient.getName(), "test");
    }
}