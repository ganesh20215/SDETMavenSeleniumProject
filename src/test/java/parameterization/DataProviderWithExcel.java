package parameterization;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderWithExcel {

    public static WebDriver driver;


    @DataProvider(name = "data")
    public Object[][] dataProviderFunction() throws IOException {
        Object[][] arrObj = getExcelData("C:\\Users\\Ganesh\\OneDrive\\Desktop\\testData.xlsx", "testCase1");
        return arrObj;
    }

    public String[][] getExcelData(String filePath, String sheetName) throws IOException {
        String[][] data = null;

        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheet(sheetName);
        XSSFRow row = sheet.getRow(0);
        int noOfRows = sheet.getPhysicalNumberOfRows(); //5
        int noOfCols = row.getLastCellNum();        //2

        Cell cell;

        data = new String[noOfRows - 1][noOfCols];

        for (int i =1; i<noOfRows; i++){        //rows
            for (int j =0 ; j<noOfCols; j++){   //column
                row = sheet.getRow(i);
                cell= row.getCell(j);
                data[i-1][j] = cell.getStringCellValue();
            }
        }
        return data;
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
        nameElement.sendKeys(courseName + " " + cityName);
        nameElement.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.close();
    }
}
