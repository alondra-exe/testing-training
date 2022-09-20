package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnDemo {
    @Test
    public void LoginTC(){
        System.out.println("Validating login");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "LoginTC")
    public void ValidateCreateUserTC(){
        System.out.println("Creating an user");
    }

    @Test(dependsOnMethods = "LoginTC")
    public void ValidateEditUserTC(){
        System.out.println("Editing an user");
    }

    @Test(dependsOnMethods = "LoginTC")
    public void ValidateDeleteUserTC(){
        System.out.println("Deleting an user");
    }

    @Test
    public void ValidateLogo(){
        System.out.println("Validating logo");
    }
}
