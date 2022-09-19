package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        WebElement dropdown = driver.findElement(By.xpath("//select"));
        Select obj = new Select(dropdown);
        obj.selectByValue("MEX");

        List<WebElement> options = driver.findElements(By.tagName("option"));
        System.out.println(options.size());

        List<WebElement> options2 = dropdown.findElements(By.tagName("option"));
        System.out.println("Total country options are: " + options2.size());

        Thread.sleep(5000);
        driver.close();
    }
}
