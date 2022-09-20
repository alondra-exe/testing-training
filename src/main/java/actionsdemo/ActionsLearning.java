package actionsdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsLearning {
    public static void main(String[] args) throws InterruptedException {
        //hover();
        //keyboardEve();
        dragAndDrop();
    }

    public static void hover() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myntra.com/");
        WebElement loginButton = driver
                .findElement(By.xpath("//a[text()='Kids'][1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).perform();
        //loginButton.click();
        Thread.sleep(3000);
        driver.quit();
    }

    public static void keyboardEve() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement username = driver.findElement(By.id("email"));
        Actions actions = new Actions(driver);
        actions.click(username).keyDown(Keys.SHIFT).sendKeys("admin").keyUp(Keys.SHIFT).build().perform();
        Thread.sleep(4000);
        driver.quit();
    }

    public static void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).build().perform();
        Thread.sleep(4000);
        driver.quit();
    }
}