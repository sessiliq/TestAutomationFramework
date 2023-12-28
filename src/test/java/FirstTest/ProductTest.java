package FirstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductTest extends TestUtil{
    //first part of the product id, second is given in data provider
    private final static String BASE_PRODUCT_ID = "add-to-cart-sauce-labs-";

    //what we read from data provider is accepted as parameter in the method
    @Test (dataProvider = "items list")
    public void AddProductToCart(String itemName){
       //First - login
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement itemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + itemName));
        itemToBeAdded.click();

        WebElement shoppingCartBadge = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));

        Assert.assertEquals(shoppingCartBadge.getText(), "1");
    }

    //the test will be executed for all data(items) in Data Provider
    @DataProvider(name = "items list")
    public Object[][] getItems(){
        return new Object[][]{
                {"bike-light"},
                {"bolt-t-shirt"}
        };
    }
}
