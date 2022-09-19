package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        driver.findElement(By.id("alertexamples")).click();
        Thread.sleep(3000);

        // Validate the text
        String alertMessage = driver.switchTo().alert().getText();
        String expectAlertMessage = "I am an alert box!";
        if (alertMessage.equals(expectAlertMessage)) {
            System.out.println("Alert message is correct, test case passed!");
        }
        else
            System.out.println("Alert message is incorrect, test case failed!");
        //

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.id("promptexample")).click();
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Elizabeth");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        driver.close();
    }
}
