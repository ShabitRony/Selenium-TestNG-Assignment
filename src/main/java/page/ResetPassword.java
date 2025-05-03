//package page;
//
//import config.Setup;
//import config.UserModel;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class ResetPassword extends Setup {
//    @FindBy(tagName = "input")
//    WebElement txtInput;
//    @FindBy(tagName = "button")
//    WebElement btnReset;
//
//    public ResetPassword(WebDriver driver){
//        PageFactory.initElements(driver,this);
//    }
//    public void resetPassword( String email){
//    txtInput.sendKeys(email);
//    btnReset.click();
//    }
//
//}
