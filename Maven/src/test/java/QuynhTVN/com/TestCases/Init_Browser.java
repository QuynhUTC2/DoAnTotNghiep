package QuynhTVN.com.TestCases;

import QuynhTVN.com.Base.CaptureHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Init_Browser {
    public static WebDriver driver = null;


    public static WebDriver getDriver() {
        return driver;
    }

    public static void SetUp_ChromeDriver(){

        System.out.println("Wait for Chrome loading...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open maximum screen
        driver.manage().window().maximize();

    }

    public static void SetUp_EdgeDriver(){

        System.out.println("Wait for Microsoft Edge loading...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open maximum screen
        driver.manage().window().maximize();

    }

    public static void SetUp_FireFoxDriver(){

        System.out.println("Wait for Fire Fox loading...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open maximum screen
        driver.manage().window().maximize();
    }

    public static void TearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
