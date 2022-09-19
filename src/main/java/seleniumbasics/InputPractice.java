package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        /*
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("55");
         */

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.findElement(By.name("username")).sendKeys("elizabeth");
        driver.findElement(By.name("password")).sendKeys("pass");
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys("Selenium input practice.");
        driver.findElement(By.xpath("//input[@value = 'cb3']")).clear();
        driver.findElement(By.xpath("//input[@value = 'cb2']")).click();
        driver.findElement(By.xpath("//input[@value = 'rd3']")).click();
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        Thread.sleep(3000);
        driver.close();
    }
}
