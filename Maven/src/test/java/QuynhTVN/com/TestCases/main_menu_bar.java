package QuynhTVN.com.TestCases;

import QuynhTVN.com.Base.CaptureHelper;
import QuynhTVN.com.Base.ReportListener;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class main_menu_bar extends Init_Browser{
    public static void SetUp_MainMKP(){
        SetUp_EdgeDriver();
        driver.navigate().to("https://qc.atalink.com.vn");
    }

 /*   // Nó sẽ thực thi sau mỗi lần thực thi testcase (@Test)
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
    }
*/
    @Test(description = "Verify default test in Box search for")
    public void C01_Verify_Default_Box_SearchFor() {

        SetUp_MainMKP();
        String text_of_Box = driver.findElement(By.xpath("//body/div[@id='__next']/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
        switch (text_of_Box) {
            case "Sản phẩm" -> System.out.println("Pass");
            case "Thư chào hàng" -> System.out.println("Pass");
            case "Yêu cầu báo giá" -> System.out.println("Pass");
            case "Doanh nghiệp" -> System.out.println("Pass");
            case "Hội / Hiệp hội" -> System.out.println("Pass");
            case "KCN / KCX / CCN" -> System.out.println("Pass");
            case "Người dùng" -> System.out.println("Pass");
            default -> System.out.println("Fales - Don't find to the element");
        }
    }

    @Test(description = "Verify select in drop down list of search bar")
    public void C02_Verify_Dropdown_searchBar() {

        SetUp_MainMKP();
        driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();

        int count = 0;
        for (int i= 1; i <= 7; i++){
            String type = driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li["+ i +"]")).getText();
            //System.out.println(type);
            if (i == 1 && type.equals("products_v2Sản phẩm")){
                count = 1;
            }else if (i == 2 && type.equals("sales_offers_v2Thư chào hàng")){
                count += 1;
            }else if (i == 3 && type.equals("sales_offers_v2Yêu cầu báo giá")){
                count += 1;
            }else if (i == 4 && type.equals("company_v2Doanh nghiệp")){
                count += 1;
            }else if (i == 5 && type.equals("association_v2Hội / Hiệp hội")){
                count += 1;
            }else if (i == 6 && type.equals("association_v2KCN / KCX / CCN")){
                count += 1;
            }else if (i == 7 && type.equals("user_v2Người dùng") && count == 6 ){
                System.out.println("Pass");
            }else {
                System.out.println("Fales - Don't find to the element");
            }
        }
    }

    @Test(description = "Verify selected in box when click on a select in drop down list categories")
    public void C03_Verify_TextinBox_clickOn_aOption () throws Exception{
        SetUp_MainMKP();
        driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();

        int random_int = (int)(Math.random() * (7 - 1 + 1) + 1);
        for (int i = random_int; i<= random_int; i++) {
            driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[" + i + "]")).click();
            Thread.sleep(2000);

            String Text_inbox = driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
            String title = driver.getTitle();
            switch (Text_inbox) {
                case "Sản phẩm" -> {
                    if (title.equals("ATALINK - Tìm kiếm sản phẩm")) {
                        System.out.println("Pass");
                    }
                }
                case "Thư chào hàng" -> {
                    if (title.equals("ATALINK - Thư chào hàng")) {
                        System.out.println("Pass");
                    }
                }
                case "Yêu cầu báo giá" -> {
                    if (title.equals("ATALINK - Yêu cầu báo giá")) {
                        System.out.println("Pass");
                    }
                }
                case "Doanh nghiệp" -> {
                    if (title.equals("ATALINK - Tìm kiếm doanh nghiệp")) {
                        System.out.println("Pass");
                    }
                }
                case "Hội / Hiệp hội" -> {
                    if (title.equals("ATALINK - Tìm kiếm Hội / Hiệp hội")) {
                        System.out.println("Pass");
                    }
                }
                case "KCN / KCX / CCN" -> {
                    if (title.equals("ATALINK - Tìm kiếm KCN / KCX / CCN")) {
                        System.out.println("Pass");
                    }
                }
                case "Người dùng" -> {
                    if (title.equals("ATALINK - Tìm kiếm người dùng")) {
                        System.out.println("Pass");
                    }
                }
                default -> System.out.println("Fales - Navigator to ");
            }
        }
    }

    @Test(description = "Verify placeholder of field search")
    public void C04_Verify_placeHolder_of_FieldSearch () throws Exception{
        SetUp_MainMKP();
        driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();

        int random_int = (int)(Math.random() * (7 - 1 + 1) + 1);
        for (int i = random_int; i<= random_int; i++) {
            driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[" + i + "]")).click();
            Thread.sleep(2000);

            String Text_inbox = driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
            String placeholder = driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]")).getText();
            switch (Text_inbox) {
                case "Sản phẩm" -> {
                    if (placeholder.equals("Nhập tên sản phẩm...")) {
                        System.out.println("Pass");
                    }
                }
                case "Thư chào hàng" -> {
                    if (placeholder.equals("Nhập tên, từ khóa thư chào hàng...")) {
                        System.out.println("Pass");
                    }
                }
                case "Yêu cầu báo giá" -> {
                    if (placeholder.equals("Nhập tên, từ khóa yêu cầu báo giá...")) {
                        System.out.println("Pass");
                    }
                }
                case "Doanh nghiệp" -> {
                    if (placeholder.equals("Nhập tên doanh nghiệp, mã số thuế...")) {
                        System.out.println("Pass");
                    }
                }
                case "Hội / Hiệp hội" -> {
                    if (placeholder.equals("Nhập tên Hội, Hiệp hội...")) {
                        System.out.println("Pass");
                    }
                }
                case "KCN / KCX / CCN" -> {
                    if (placeholder.equals("Nhập tên KCN / KCX / CCN")) {
                        System.out.println("Pass");
                    }
                }
                case "Người dùng" -> {
                    if (placeholder.equals("Nhập tên người dùng...")) {
                        System.out.println("Pass");
                    }
                }
                default -> System.out.println("Fales - Placeholder is wrong");
            }
        }
    }

    @Test(description = "Verify in case click on button 'Sign in'")
    public void C05_Verify_ClickOn_BtnSignIn() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.linkText("Đăng nhập")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();

        Assert.assertEquals(title,"ATALINK - Đăng nhậ");
    }

    @Test(description = "Verify in case click on button 'Sign up'")
    public void C06_Verify_ClickOn_BtnSignUp() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.linkText("Đăng ký")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();

        Assert.assertEquals(title,"ATALINK - Đăng ký tài khoả");
    }

    @Test(description = "Verify in case click on button 'Notification'")
    public void C07_Verify_ClickOn_BtnNoti() throws Exception{

        SetUp_MainMKP();
        driver.findElement(By.xpath("//span[contains(text(),'Thông báo')]")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"ATALINK - Đăng nhập");
    }

    @Test(description = "Verify in case click on button 'New'")
    public void C08_Verify_ClickOn_BtnNew() throws Exception {

        SetUp_MainMKP();
        driver.findElement(By.xpath("//div[contains(text(),'Tin tức')]")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"ATALINK - Tin tức");
    }

    @Test(description = "Verify in case click on button 'Task'")
    public void C09_Verify_ClickOn_BtnTask() throws InterruptedException{

        SetUp_MainMKP();
        driver.findElement(By.xpath("//div[contains(text(),'Công việc')]")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals(title, "ATALINK - Đăng nhập");
    }

    @Test(description = "Verify in case click on button 'Help'")
    public void C10_Verify_ClickOn_BtnHelp() throws InterruptedException {

        SetUp_MainMKP();
        driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/div[2]/div[2]/a[2]/div[1]/div[1]")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();

        Assert.assertEquals(title, "ATALINK Help");
    }

    @AfterTest
    public void quit() throws Exception {
        TearDown();
    }


}
