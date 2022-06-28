package QuynhTVN.com.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class List_BR_Page extends Init_Browser {
    public static void SetUp_ListSalesOfer(){
        SetUp_ChromeDriver();
        driver.navigate().to("https://qc.atalink.com.vn/buying-requests");
    }
    @Test(description = "Verify title of list Buying Request screen screen")
    public void C01_Verify_TitlePage_ListSF() throws Exception {

        SetUp_ListSalesOfer();
        // Get title of web
        String titleTest = "ATALINK - Yêu cầu báo giá";
        String titleweb = driver.getTitle();
        Assert.assertEquals(titleweb,titleTest);
        TearDown();
    }
    @Test(description = "Verify behavior in case click on any Buying Request")
    public void C02_Verify_ClickOn_AnySF() throws Exception {

        SetUp_ListSalesOfer();
        String detail_SF = "Tai nghe Bluetooth SongX TWS Trắng (White)";
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/section[1]/div[2]/section[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), detail_SF);
        TearDown();
    }
}
