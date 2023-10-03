package parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizationWithDataProvider {

    public static WebDriver driver;


    @DataProvider(name = "data")
    public Object[][] dataProviderFunction() {
        return new Object[][]{{"Selenium", "Pune"}, {"Java", "Nashik"}};
    }

    @Parameters({"browserName"})
    @BeforeMethod
    public void beforeMethodExample(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\Downloads\\4Sept2023\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();  //UpCasting
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ganesh\\Downloads\\4Sept2023\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
            driver = new FirefoxDriver();  //UpCasting
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Ganesh\\Downloads\\4Sept2023\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
            driver = new EdgeDriver();  //UpCasting
        } else {
            throw new RuntimeException("please select the correct browser");
        }
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "data")
    public void verifyGoogleWebsite1(String courseName, String cityName) throws InterruptedException {
        WebElement nameElement = driver.findElement(By.name("q"));
        nameElement.sendKeys(courseName + " "+ cityName);
        nameElement.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.close();
    }

}

