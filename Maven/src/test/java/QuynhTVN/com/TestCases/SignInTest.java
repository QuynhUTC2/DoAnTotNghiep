package QuynhTVN.com.TestCases;

import QuynhTVN.com.Base.ValidateHelper;
import QuynhTVN.com.Pages.SignInPage;
import QuynhTVN.common.helper.ExcelHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest{
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private SignInPage signInPage;
    private ExcelHelper excel;


    @BeforeClass
    public void SetUp_Excel(){
        excel = new ExcelHelper();
    }

    @Test(description = " Verify behavior in case sign in successfully")
    public void C01_SignInLagre() throws Exception {
        driver.quit();

        //Set up duong dan cho file excel
        excel.setExcelFile("src\\test\\Resources\\DataTest.xlsx","Sheet1");

        for (int i = 9;i <= 11; i++) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            validateHelper = new ValidateHelper(driver);
            signInPage = new SignInPage(driver);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Open maximum screen
            driver.manage().window().maximize();
            driver.get("https://qc.atalink.com.vn/sign-in");
            driver.findElement(By.linkText("Đăng nhập")).click();
            //Read data from file excel
            signInPage.SignIn(excel.getCellData("UserName", i), excel.getCellData("PassWord", i));

            Thread.sleep(2000);
            //Write data to file excel
            if (driver.getTitle().equals("ATALINK - Đăng nhập")) {
                excel.setCellData("False", i, 2);
            } else {
                excel.setCellData("Pass", i, 2);
            }

            Thread.sleep(2000);


        }
    }
}
