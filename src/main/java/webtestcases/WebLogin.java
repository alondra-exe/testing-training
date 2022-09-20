package webtestcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebLogin {
    //@BeforeTest
    @BeforeSuite
    public void webLoginBeforeSuite(){
        System.out.println("WebLogin Before Suite Method");
    }

    @Test(groups = "smoke")
    public void Web1(){
        System.out.println("Web method 1");
    }

    @Test
    public void Web2(){
        System.out.println("Web method 2");
    }

    @Test
    public void Web3(){
        System.out.println("Web method 3");
    }
}
