package QuynhTVN.com.TestCases;

import QuynhTVN.com.Base.CaptureHelper;
import QuynhTVN.com.Base.ReportListener;
import QuynhTVN.com.Base.TestListener;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

@Listeners(ReportListener.class)
public class MKP_Homepage extends Init_Browser{
    public static void SetUp_MainMKP(){
        SetUp_ChromeDriver();
        driver.navigate().to("https://qc.atalink.com.vn");
    }
/*
    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        // Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
        // Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        // passed = SUCCESS và failed = FAILURE

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                CaptureHelper.captureScreenshot(driver,result.getName());
                CaptureHelper.startRecord(result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }*/

   @Test(description = "Verify title of main page")
    public void C01_Verify_TitlePage() throws Exception {

        SetUp_MainMKP();
        // Get title of web
        String titleTest = "ATALINK - Giải pháp quản trị chuỗi cung ứn";
        String titleweb = driver.getTitle();

        Assert.assertEquals(titleweb,titleTest);
        TearDown();
    }

    @Test(description = "Verify in case click on feature categories")
    public void C02_Verify_ClickOn_Category() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.xpath("//section[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).click();

        int count = 0;
        for (int i= 1; i <= 12; i++){
            String type = driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div["+ i +"]")).getText();
            //System.out.println(type);
            if (i == 1 && type.equals("Bất Động Sản")){
                count = 1;
            }else if (i == 2 && type.equals("Nguyên Vật Liệu/Vật Liệu Xây Dựng")){
                count += 1;
            }else if (i == 3 && type.equals("")){
                count += 1;
            }else if (i == 4 && type.equals("")){
                count += 1;
            }else if (i == 5 && type.equals("")){
                count += 1;
            }else if (i == 6 && type.equals("")){
                count += 1;
            }else if (i == 7 && type.equals("")){
                System.out.println("Pass");
            }else if (i == 8 && type.equals("")){
                System.out.println("Pass");
            }else if (i == 9 && type.equals("")){
                System.out.println("Pass");
            }else if (i == 10 && type.equals("")){
                System.out.println("Pass");
            }else if (i == 11 && type.equals("")){
                System.out.println("Pass");
            }else if (i == 12 && type.equals("") && count == 11 ){
                System.out.println("Pass");
            }else {
                System.out.println("Fales - Don't find to the element");
            }
        }
        TearDown();

    }

    @Test(description = "Verify in case click on click on 'over view'")
    public void C03_Verify_ClickOn_OverView() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.linkText("Tổng quan")).click();

        TearDown();
    }

    @Test(description = "Verify in case click on button 'for buyer'")
    public void C04_Verify_ClickOn_ForBuyer() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.linkText("Dành cho người mua")).click();

        TearDown();
    }

    @Test
    public void C05_Verify_ClickOn_ForSaler() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.linkText("Dành cho người bán")).click();

        TearDown();
    }

    @Test
    public void C06_Verify_ClickOn_Pricing() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.linkText("Bảng giá")).click();

        TearDown();
    }

    @Test
    public void C07_Verify_ClickOn_Banner1() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.xpath("//section[1]/div[2]/section[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/img[1]")).click();

        TearDown();
    }

    @Test
    public void C08_Verify_ClickOn_Banner2() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.xpath("//button[contains(text(),'2')]")).click();
        driver.findElement(By.xpath("//section[1]/div[2]/section[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/img[1]")).click();

        TearDown();
    }

    @Test
    public void C09_Verify_ClickOn_Banner3() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.xpath("//button[contains(text(),'3')]")).click();
        driver.findElement(By.xpath("//section[1]/div[2]/section[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/img[1]")).click();

        TearDown();
    }

    @Test
    public void C10_Verify_ClickOn_Banner4() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.xpath("//button[contains(text(),'4')]")).click();
        driver.findElement(By.xpath("//section[1]/div[2]/section[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/img[1]")).click();

        TearDown();
    }

}
