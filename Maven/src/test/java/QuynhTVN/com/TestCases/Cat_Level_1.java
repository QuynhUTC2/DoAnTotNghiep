package QuynhTVN.com.TestCases;

public class Cat_Level_1 extends Init_Browser{
    public static void SetUp_MainMKP(){
        SetUp_ChromeDriver();
        driver.navigate().to("https://qc.atalink.com.vn");
    }
}
