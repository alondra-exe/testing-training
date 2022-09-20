package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise {
    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    }

    @Test(priority = 1)
    public void ValidateDogPage(){
        driver.findElement(By.xpath("//img[@src = '../images/sm_dogs.gif']")).click();
    }

    @Test(priority = 2)
    public void ValidateAddToCartDog() throws InterruptedException {
        ValidateDogPage();
        driver.findElement(By
                .xpath("//a[@href = '/actions/Catalog.action?viewProduct=&productId=K9-BD-01']"))
                .click();
        driver.findElement(By
                .xpath("//a[@href = '/actions/Cart.action?addItemToCart=&workingItemId=EST-6']"))
                .click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void ValidateQuantityAdded() throws InterruptedException {
        ValidateAddToCartDog();
        ValidateAddToCartDog();
        String quantity = driver.findElement(By.name("EST-6")).getAttribute("value");
        Assert.assertEquals(quantity, "2");
    }

    @Test(priority = 4)
    public void RemoveFromCartDog() throws InterruptedException {
        ValidateAddToCartDog();
        driver.findElement(By.xpath("//a[text() = 'Remove']")).click();
        Thread.sleep(2000);
        boolean removed = driver.findElement(By
                        .xpath("//b[text() = 'Your cart is empty.']"))
                .isDisplayed();
        Assert.assertTrue(removed);
    }

    @Test(invocationCount = 2)
    public void ValidateCartPage() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='MenuContent']/a[1]")).click();
        boolean cart = driver.findElement(By.xpath("//h2[text() = 'Shopping Cart']")).isDisplayed();
        Thread.sleep(1000);
        Assert.assertTrue(cart);
    }

    @AfterMethod
    public void CloseSetUp(){
        driver.quit();
    }
}
