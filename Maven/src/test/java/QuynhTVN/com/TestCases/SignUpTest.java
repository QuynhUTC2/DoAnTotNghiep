package QuynhTVN.com.TestCases;

import QuynhTVN.com.Base.ValidateHelper;
import QuynhTVN.com.Pages.SignInPage;
import QuynhTVN.com.Pages.SignUpPage;
import QuynhTVN.common.helper.ExcelHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private SignUpPage signUpPage;
    private ExcelHelper excel;



    @BeforeClass
    public void SetUp_Excel(){
        excel = new ExcelHelper();
    }

    @Test
    public void C01_SignUpLagre() throws Exception {

        //Set up duong dan cho file excel
        excel.setExcelFile("src\\test\\Resources\\Data_SignUp.xlsx","Sheet1");

        for (int i = 1; i <= 3 ; i++) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            validateHelper = new ValidateHelper(driver);
            signUpPage = new SignUpPage(driver);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Open maximum screen
            driver.manage().window().maximize();

            driver.get("https://qc.atalink.com.vn/sign-up");
            //Read data from file excel
            signUpPage.SignUp(excel.getCellData("LastName", i), excel.getCellData("FirstName", i),excel.getCellData("Email/SDT",i),excel.getCellData("PassWord",i),excel.getCellData("PassWord_Confirm",i));

            Thread.sleep(2000);
            //Write data to file excel
            if (driver.getTitle().equals("ATALINK - Đăng ký tài khoản")) {
                excel.setCellData("False", i, 5);
            } else {
                excel.setCellData("Pass", i, 5);
            }

            Thread.sleep(2000);

            driver.quit();
        }
    }
}
