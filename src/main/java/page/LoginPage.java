package page;

import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends  BasePage{
    @FindBy(id = "email")
    WebElement  txtEmail;
    @FindBy(id = "password")
    WebElement txtPassword;
    @FindBy(tagName = "button")
    WebElement btnLogin;
    @FindBy(css = "[type=button]")
    List<WebElement> btnProfileIcon;
    @FindBy(css = "[role=menuitem]")
    List<WebElement> menuItem;
    @FindBy(tagName = "button")
    List<WebElement> button;

    public LoginPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String email, String password) {
        this.sendKeys(txtEmail,email);
        this.sendKeys(txtPassword,password);
        this.clickBtn(btnLogin);

//        txtemail.sendKeys(email);
//        txtPassword.sendKeys(password);
//        btnLogin.click();
    }

    public void doLogout() {
        btnProfileIcon.get(0).click();
        menuItem.get(1).click();

    }
}
