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

public class AssertionsDemo {
    WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void ValidateTitle() {
        String expTitle = "Facebook - Inicia sesión o regístrate";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, expTitle);
    }

    @Test
    public void ValidateCreateNewAccountButton() {
        boolean isPresent = driver.findElement(By.linkText("Crear cuenta nueva")).isDisplayed();
        try {
            Assert.assertTrue(isPresent);
        } catch (NoSuchElementException e) {
            Assert.assertTrue(isPresent);
        }
    }

    @AfterMethod
    public void closeSetUp() {
        driver.quit();
    }
}
