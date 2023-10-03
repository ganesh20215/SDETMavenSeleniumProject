package attributeannotations;

import org.testng.annotations.Test;

public class InvocationCountExample {

    @Test(invocationCount = 1000, invocationTimeOut = 10)
    public void testInvocation() {
        System.out.println("testInvocation");
    }
}
