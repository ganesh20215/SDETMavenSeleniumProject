package annotation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AnnotationOfBeforeMethodExample {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClassExample(){
        System.out.println("Before Class");
    }


    @BeforeMethod
    public void beforeMethodExample(){
        System.out.println("Before Method");
    }

    @Test
    public void testCase1() {
        System.out.println("test case 1");
    }

    @Test
    public void testCase2() {
        System.out.println("test case 2");
    }

    @Test
    public void testCase3() {
        System.out.println("test case 3");
    }

    @Test
    public void testCase4() {
        System.out.println("test case 4");
    }


    @AfterMethod
    public void afterMethodExample(){
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClassExample(){
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
}
