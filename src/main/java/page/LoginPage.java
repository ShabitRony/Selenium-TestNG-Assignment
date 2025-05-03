package page;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    WebElement txtEmail;

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

    @FindBy(className = ".add-cost-button")
    List<WebElement> btnAddCost;

    public LoginPage(WebDriver driver) {
        super(driver); // ✅ correctly pass the driver to BasePage
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String email, String password) throws InterruptedException {
        enterText(txtEmail, email);
        enterText(txtPassword, password);
        btnLogin.click(); // ✅ using WebElement directly
    }
    public void doLogout() {
        btnProfileIcon.get(0).click();
        menuItem.get(1).click();
    }
    public static String[] getUserCredentials() throws IOException, ParseException {
        // Reading the JSON file
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject jsonObject = (JSONObject) jsonArray.get(jsonArray.size() - 1); // Fetch last user

        // Fetching email and password from JSON
        String email = jsonObject.get("email").toString();
        String password = jsonObject.get("password").toString();

        // Returning credentials as an array
        return new String[]{email, password};
    }
}




