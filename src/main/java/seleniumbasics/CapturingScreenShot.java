package seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CapturingScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.mx/");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String formattedDate = formatter.format(date);
        System.out.println(date);
        System.out.println(formattedDate);
        formattedDate = formattedDate.replaceAll("/", "-")
                                     .replaceAll(":", "_");
        TakesScreenshot ss = (TakesScreenshot) driver;
        File srcFile = ss.getScreenshotAs(OutputType.FILE);
        //
        FileUtils.copyFile(srcFile, new File("./screenshots/test " + formattedDate + ".png"));
        driver.quit();
    }
}
