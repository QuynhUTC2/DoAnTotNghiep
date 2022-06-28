package QuynhTVN.com.TestCases;

public class Detail_BR_Test extends Init_Browser{
    public static void SetUp_MainMKP(){
        SetUp_ChromeDriver();
        driver.navigate().to("https://qc.atalink.com.vn");
    }
}
