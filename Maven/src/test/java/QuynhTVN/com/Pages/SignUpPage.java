package QuynhTVN.com.Pages;

import QuynhTVN.com.Base.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By E_firstName = By.id("firstName");
    private By E_lastName = By.id("lastName");
    private By E_username = By.id("username");
    private By E_passWord = By.id("password");
    private By E_Pass_confirm = By.id("confirm");
    private By btn_agree = By.xpath("//section[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]/input[1]");
    private By btn_SubmitSignIn = By.xpath("//*[@id='SignIn']/div[6]/button");

    public SignUpPage(WebDriver driver){

        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void SignUp(String lastname, String firstname, String username, String password, String passconfim) throws InterruptedException {

        validateHelper.WaitForPageLoading();
        validateHelper.SetText(E_lastName, lastname);
        validateHelper.SetText(E_firstName, firstname);
        validateHelper.SetText(E_username, username);
        validateHelper.SetText(E_passWord, password);
        validateHelper.SetText(E_Pass_confirm, passconfim);
        validateHelper.ClickElement(btn_agree);
        Thread.sleep(2000);
        validateHelper.ClickElement(btn_SubmitSignIn);

    }
}
