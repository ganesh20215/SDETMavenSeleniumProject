package dependson;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnGroupsExample {


    @Test(groups = {"smoke"})
    public void verifyLogin(){
        System.out.println("verify login");
        Assert.assertFalse(true);
    }

    @Test
    public void verifyHomePage(){
        System.out.println("verify Home Page");
    }

    @Test(dependsOnGroups = {"smoke"}, alwaysRun = false)
    public void verifySendARequest(){
        System.out.println("verify end A Request");
    }

    @Test
    public void verifyReviewProfile(){
        System.out.println("verify Review Profile");
    }
}
