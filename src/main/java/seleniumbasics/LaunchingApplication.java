package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchingApplication {
    public static void main(String[] args){
        // step 0: Configuring the set
        WebDriverManager.chromedriver().setup();
        // step 1: Open the browser
        WebDriver driver = new ChromeDriver();
        // step 2:
        driver.get("https://www.facebook.com/");

        // Will identify the element on the page
        WebElement username = driver.findElement(By.id("email"));
        // Will send the text on that element
        username.sendKeys("testadmin@gmail.com");

        driver.findElement(By.id("pass")).sendKeys("passwordtest");
        driver.findElement(By.name("login")).click();
        driver.close();
    }
}
