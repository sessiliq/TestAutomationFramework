package FirstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductTest extends TestUtil{
    //
    private final static String PRODUCT_ID = "add-to-cart-sauce-labs-";

    @Test
    public void AddProductToCart(){
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
    }

    @DataProvider(name = "items list")
    public Object[][] getItems(){
        return new Object[][]{
                {"bike-light"}
        }
    }
}
