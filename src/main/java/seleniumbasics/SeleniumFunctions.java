package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFunctions {
    public static void main(String[] args) throws InterruptedException {
        /*
        Selenium Functions:
        get(); - To launch the given url
        Locators
        select - class to detect dropdown
        handling iFrames
        Close and quit
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        // DRIVER GET METHODS
        String curl = driver.getCurrentUrl();
        System.out.println(curl);
        System.out.println(driver.getPageSource());
        System.out.println(driver.getClass());

        String expTitle = "Test Page For JavaScript Alerts";
        String actTitle = driver.getTitle();
        if(expTitle.equals(actTitle)){
            System.out.println("Test case passed");
        }
        else{
            System.out.println("Test case failed");
        }

        // get methods on the elements
        System.out.println(driver.findElement(By.id("alertexamples")).getText());
        driver.navigate().to("https://www.amazon.in/");
        WebElement temp = driver.findElement(By.xpath("//li[@class='nav_first'][1]"));
        System.out.println(temp.getText());
        System.out.println(temp.getTagName());
        WebElement temp1 = driver.findElement(By.xpath("//li[@class='nav_first'][1]/a"));
        System.out.println(temp.getAttribute("href"));
        /*
        isVisible
        isEnabled
        isSelected
         */
        // Wait concept - Synchronization
        Thread.sleep(2000);
        driver.quit();
    }
}
