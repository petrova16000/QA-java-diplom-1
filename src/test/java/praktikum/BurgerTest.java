package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class BurgerTest {

    @Test
    public void setBuns() {
        Bun bun = new Bun("test", 14);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun.getName(), bun.name);
        Assert.assertEquals(burger.bun.getPrice(), bun.price, 0);
    }

    @Test
    public void addIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"test", 17);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.get(0).getType(), ingredient.type);
        Assert.assertEquals(burger.ingredients.get(0).getName(), ingredient.name);
        Assert.assertEquals(burger.ingredients.get(0).getPrice(), ingredient.price,0);
    }

    @Test
    public void removeIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"test", 17);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.get(0).getType(), ingredient.type);
        Assert.assertEquals(burger.ingredients.get(0).getName(), ingredient.name);
        Assert.assertEquals(burger.ingredients.get(0).getPrice(), ingredient.price,0);
        burger.removeIngredient(0);
        Assert.assertEquals(burger.ingredients, new ArrayList<>());
    }

    @Test
    public void moveIngredient() {
        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE,"test1", 17);
        Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING,"test2", 34);
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(burger.ingredients.get(0).getType(), ingredientFilling.type);
        Assert.assertEquals(burger.ingredients.get(0).getName(), ingredientFilling.name);
        Assert.assertEquals(burger.ingredients.get(0).getPrice(), ingredientFilling.price, 0);
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("test", 14);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE,"test1", 17);
        Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING,"test2", 34);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        Assert.assertEquals(burger.getPrice(), 79, 0);
    }

    @Test
    public void getReceipt() {
        Bun bun = new Bun("test", 14);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE,"test1", 17);
        Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING,"test2", 34);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.getReceipt();
        Assert.assertEquals(burger.getReceipt(),String.join("\r\n", "(==== test ====)",
                "= sauce test1 =", "= filling test2 =", "(==== test ====)", "", "Price: 79,000000", ""));

    }
}