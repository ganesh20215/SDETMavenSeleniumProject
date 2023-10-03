package annotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationExample {

    public static WebDriver driver;

    @BeforeMethod
    public void beforeMethodExample(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\Downloads\\4Sept2023\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();  //UpCasting
    }

    @Test
    public void testCase1() {
        driver.navigate().to("https://www.abhibus.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testCase2() {
        driver.navigate().to("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @Test
    public void testCase3() {
        driver.navigate().to("https://www.flipkart.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testCase4() {
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethodExample(){
        driver.close();
    }
}
