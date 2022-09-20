package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizedTC {
    @Test(groups = "parameters")
    @Parameters({ "username", "password" })
    public void LoginTest(String username, String password) {
        System.out.println("Login TC");
        System.out.println("Username is --> " + username);
        System.out.println("Password is --> " + password);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        driver.quit();
    }

    public WebDriver driver;
    @Test
    @Parameters({"browser"})
    public void DriverSelect(String browser) throws InterruptedException {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.quit();

        // Data driver using Apache POI and it's implementation.
    }
}
