package FirstTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestUtil {
    //variable type WebDriver
    public WebDriver driver;

    //annotation before method is executed before any other
    @BeforeMethod
    //method for setting the web driver
    public void setupDriverAndOpenUrl(){
        //set for chrome
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        //get the url of the page we want to test
        driver.get("https://www.saucedemo.com");
    }
    //After method - it is executed after all other methods/tests
    //typically the name of the method that kill some process is tearDown; it can be different but this is most used
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
