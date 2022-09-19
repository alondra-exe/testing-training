package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. Implicit Wait: define once, applicable for all the elements on the page
        2. Explicit Wait: is specifically for a specific element
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.navigate().to("https://www.amazon.in/");
        //System.out.println(driver.findElement(By.xpath("//li[@class='nav_first'][1]/assfds")));

        driver.get("http://www.seleniumframework.com/practiceform/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Thread.sleep(4000);
        driver.findElement(By.id("timingAlert")).click();
        // Need to wait until the alert is present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        //Thread.sleep(6000);
        //driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.quit();
    }
}
