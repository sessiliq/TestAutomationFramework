package FirstTest;
/*
get(String url) - Loads a new web page in the current browser window.
findElement(By by) - Finds the first WebElement using the given method.
findElements(By by) - Finds all elements within the current page.
getCurrentUrl() - Gets a string representing the current URL in the browser
getPageSource() - Gets the source of the last loaded page.
getTitle() - The title of the current page.
getWindowHandles() - Returns a set of window handles which can be used to iterate over all open windows of this WebDriver instance by passing them to switchTo()
switchTo() - Sends future commands to a different frame or window.
close() - Closes the current window, quitting the browser if it's the last window currently open.
quit () - Quits this driver, closing every associated window.
clear() - If this element is a text entry element, this will clear the value.
click() - Click this element.
sendKeys(String text) - Use this method to simulate typing into an element, which set its value.
getAttribute(String) - Get the value of the given attribute of the element.
getTagName() - Get the tag name of this element.
getText() - Get the visible text of this element.
isDisplayed() - Whether this element is displayed or not.
isEnabled() - Whether this element is enabled or not.
isSelected() - Whether this element is selected or not. Usually for checkboxes.
submit() - If this current element is a form, or an element within a form, then this will be submitted to the remote server.
clickAndHold() - Clicks (without releasing) at the current mouse location.
click() - Clicks at the current mouse location.
sendKeys(String text) - Send keys to the active element.
doubleClick() - Performs a double-click at the current mouse location.
dragAndDrop() - A convenience method that performs click-and-hold at the location of the source element, moves to the location of the target element, then releases the mouse.
moveToElement(WebElement element) - Moves the mouse to the middle of the element.
pause(long pause) - Performs a pause.
build() - Generates a composite action containing all actions so far, ready to be performed

 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestUtil{
    //When we use Test annotation we don't need Main method. Entry point is given after the annotation
    //annotation Test - for the particular test
    @Test
    //method for particular test
    public void successfulLogin(){
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

    @Test
    public void unsuccessfulLogin(){
        driver.get("https://www.abv.bg");

        WebElement abvUserInput = driver.findElement(By.id("username"));
        abvUserInput.click();
        abvUserInput.clear();
        abvUserInput.sendKeys("test");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("test");

        WebElement loginBtn = driver.findElement(By.id("loginBut"));
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.id("form.errors"));

        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
