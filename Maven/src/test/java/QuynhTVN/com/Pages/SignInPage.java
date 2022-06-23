package QuynhTVN.com.Pages;

import QuynhTVN.com.Base.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By E_UserName = By.id("SignIn_username");
    private By E_PassWord = By.id("SignIn_password");
    private By btn_Submit = By.xpath("//*[@id='SignIn']/div[6]/button");

    public void SignIn(String UserName, String PassWord){
        validateHelper.WaitForPageLoading();
        validateHelper.SetText(E_UserName, UserName);
        validateHelper.SetText(E_PassWord, PassWord);
        validateHelper.ClickElement(btn_Submit);
    }

    public SignInPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

}
