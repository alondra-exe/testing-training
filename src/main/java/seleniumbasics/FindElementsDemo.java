package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.in");
        driver.findElement(By.xpath("//li[@class='nav_first'][1]/a"))
                .getAttribute("href");
        List<WebElement> urls = driver.findElements(By.xpath("//li[@class='nav_first'][1]/a"));
        System.out.println("Using find elements:");
        for (WebElement webElement: urls) {
            System.out.println(webElement.getAttribute("href"));
        }
        driver.close();
    }
}
