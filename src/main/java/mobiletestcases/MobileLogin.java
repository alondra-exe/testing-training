package mobiletestcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MobileLogin {

    @Test(groups = "smoke")
    public void Mobile1(){
        System.out.println("Mobile method 1");
    }

    @Test
    public void Mobile2(){
        System.out.println("Mobile method 2");
    }

    @Test
    public void Mobile3(){
        System.out.println("Mobile method 3");
    }
}
