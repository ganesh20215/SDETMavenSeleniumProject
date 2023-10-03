package parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WithoutParameterization {

    @Test
    public void verifyGoogleWebsite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\Downloads\\4Sept2023\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();  //UpCasting
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();

        WebElement nameElement = driver.findElement(By.name("q"));
        nameElement.sendKeys("Selenium" + "Pune");
        nameElement.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        driver.close();
    }
}
