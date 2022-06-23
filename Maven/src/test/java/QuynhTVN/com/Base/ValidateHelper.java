package QuynhTVN.com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ValidateHelper {

    private WebDriver driver;
    private final int timeoutWaitForPageLoad = 20;
    private WebDriverWait wait;

    public ValidateHelper(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void SetText(By element, String Text){
        //Sendkey cho gia tri duoc truyen vao
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(Text);
    }

    public void ClickElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void WaitForPageLoading(){
        ExpectedCondition<Boolean> expectedConditions = new ExpectedCondition<Boolean> (){
            public Boolean apply(WebDriver driver){
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutWaitForPageLoad);
            wait.until(expectedConditions);
        }catch (Throwable error){
            Assert.fail("Time out wait for page load request");

        }
    }
}
