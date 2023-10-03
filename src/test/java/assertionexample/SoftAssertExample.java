package assertionexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

    @Test
    public void verifyRediffmailWebsite() {
        SoftAssert softAssert = new SoftAssert();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\Downloads\\4Sept2023\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();  //UpCasting
        driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();

        WebElement userNameTextBox = driver.findElement(By.id("login1"));

        softAssert.assertEquals(driver.getTitle(), "Rediffmail", "title should be match");
        softAssert.assertTrue(userNameTextBox.isDisplayed(), "username text box should be displayed");
        driver.close();
        softAssert.assertAll();

    }
}
