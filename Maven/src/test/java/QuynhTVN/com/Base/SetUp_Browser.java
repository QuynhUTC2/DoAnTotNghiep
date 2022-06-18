package QuynhTVN.com.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SetUp_Browser {
    public static WebDriver driver = null;

    public static void SetUp_Browser_ForTest(){

        System.out.println("----Choose the Brower you want to RunTest----");
        System.out.println("1. Chrome Driver");
        System.out.println("2. Edge Driver");
        System.out.println("3. FireFox Driver");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case 2:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case 3:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Don't find the Browser you want!!!");
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open maximum screen
        driver.manage().window().maximize();

    }

    public static void TearDown() throws InterruptedException, IOException {
        Thread.sleep(2000);
        CaptureHelper.stopRecord();
        driver.quit();
    }
}
