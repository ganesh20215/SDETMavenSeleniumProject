package dependson;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsExample {

    @Test(description = "verify login functionality")
    public void verifyLogin(){
        System.out.println("verify login");
        Assert.assertFalse(true);
    }

    @Test(enabled = false)
    public void verifyHomePage(){
        System.out.println("verify Home Page");
    }

    @Test(dependsOnMethods = {"verifyLogin"},alwaysRun = true)
    public void verifySendARequest(){
        System.out.println("verify end A Request");
    }

    @Test(groups = {"smoke"})
    public void verifyReviewProfile(){
        System.out.println("verify Review Profile");
    }
}
