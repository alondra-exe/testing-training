package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDown {
    public static void main(String[] args) throws InterruptedException {
        // GetWindowHandle and get window handles
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://output.jsbin.com/osebed/2");
        WebElement multiDropDown = driver.findElement(By.name("skills"));
        Select obj1 = new Select(multiDropDown);
        obj1.selectByValue("angular");
        obj1.selectByValue("css");
        obj1.selectByValue("html");
        Thread.sleep(4000);
        driver.quit();
    }
}
