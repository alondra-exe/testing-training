package testcases;

import org.testng.annotations.*;

public class TestNGBasicAnnotations {
    /*
    Suite - after and before >> xml file
    Test - after and before >> xml file
    Class - after and before (will be executed before and after the class)
    Methods - after and before (will be executed before and after the every method)
    Default priority is 0, and it goes by alphabetical order
     */
    @BeforeClass
    public void createDBConnection() {
        System.out.println("Create DB Connection");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Launching the browser");
    }

    @Test(priority = 1, groups = "smoke")
    public void loginTest() {
        System.out.println("Login Test");
    }

    @Test(priority = 2, groups = "regression")
    public void zebraTC() {
        System.out.println("Zebra TC");
    }

    @Test(priority = 4, groups = "smoke")
    public void abcTC() {
        System.out.println("ABC TC");
    }

    @Test(priority = 3, groups = "smoke")
    public void validateTitleTC() {
        System.out.println("Validating title TC");
    }

    @Test(groups = "regression")
    public void validateLogo(){
        System.out.println("Validating logo");
    }

    @Test
    public void appleTest(){
        System.out.println("Apple test");
    }

    @AfterClass
    public void closeDBConnection() {
        System.out.println("Close DB Connection");
    }

    @AfterMethod
    public void closeSetUp() {
        System.out.println("Close the application");
    }
}
