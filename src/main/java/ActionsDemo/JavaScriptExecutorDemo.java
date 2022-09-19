package ActionsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // scroll few pixels
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(3000);
        /*
        First parameter: x-axis
        it moves to the left if number is positive
        it moves to the right if number is negative
        Second parameter: y-axis
        it moves down if number is positive
        it moves up if number is negative
         */
        // scroll to the bottom of web page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        // scroll to specific element
        Thread.sleep(3000);
        driver.navigate().to("https://jqueryui.com/demos/");
        Thread.sleep(3000);
        // Scroll until Effects h2 element
        WebElement h2 = driver.findElement(By.xpath("//div[@id='content']/h2[3]"));
        js.executeScript("arguments[0].scrollIntoView()", h2);
        Thread.sleep(3000);
        driver.quit();
    }
}
