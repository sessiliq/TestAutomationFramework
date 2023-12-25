package FirstTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SuccessfulLogin {
    //variable type WebDriver
    public WebDriver driver;

    //annotation before method is executed before any other
    @BeforeMethod
    //method for setting the web driver
    public void setupDriver(){
        //set for chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //annotation Test - for the particular test
    @Test
    //method for particular test
    public void successfulLogin(){
        //get the url of the page we want to test
        driver.get("https://www.saucedemo.com");

        //create variables for different fields and buttons
        //variable for field username
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        //actions we do with the found element
        userNameInput.click();
        userNameInput.clear(); //it is good to always clear the field because there can be some old text
       // sendKeys - with this method we write in the field
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement productTittle = driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        //We use assertions to validate if test passed or failed
        //Assertions are given by TestNG
        Assert.assertTrue(productTittle.isDisplayed());
    }
}
