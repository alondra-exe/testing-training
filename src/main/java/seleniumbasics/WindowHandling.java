package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.seleniumframework.com/Practiceform/");
        System.out.println("Main Window " + driver.getTitle());
        driver.findElement(By.id("button1")).click();
        // At this point there are 2 windows present
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        System.out.println("Parent Window " + parentWindow);
        System.out.println("Child Window " + childWindow);

        driver.switchTo().window(childWindow);
        System.out.println("Child Window " + driver.getTitle());

        driver.switchTo().window(parentWindow);
        System.out.println("Parent Window " + driver.getTitle());

        driver.close();
        driver.quit();
    }
}
