package testcases;

import org.testng.annotations.Test;

public class InvocationDemo {
    @Test(invocationCount = 3)
    public void LoginTC() {
        System.out.println("Login TC");
    }
}
