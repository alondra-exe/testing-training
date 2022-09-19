package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        // WebElement dropdown = driver.findElement(By.xpath("//select"));
        //Select obj = new Select(dropdown);

        List<WebElement> options = driver.findElements(By.tagName("option"));

        System.out.println("Total country options are: " + options.size() + '\n');

        System.out.println("All countries:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        System.out.println('\n' + "Just 10 countries:");
        int country = 0;
        for (WebElement option : options) {
            country++;
            System.out.println(option.getText());
            if (country > 9){
                break;
            }
        }

        driver.close();
    }
}
