package testrunner;

import config.Setup;
import config.UserModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ResetPassword;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginTestRunner extends Setup {


//    @Test(description = "Admin Login")
    public void adminLogin(){
        LoginPage loginPage =new LoginPage(driver);
        loginPage.doLogin("admin@test.com","admin123");
    }
    @Test
    public void userLogin() throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray =(JSONArray) parser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject jsonObject =(JSONObject)jsonArray.get(jsonArray.size()-1);
        String email =jsonObject.get("email").toString();
        String password = jsonObject.get("password").toString();
        loginPage.doLogin(email,password);

        Thread.sleep(2000);
        List<WebElement> btnCost =  driver.findElements(By.tagName("button"));
        btnCost.get(1).click();

    }


}
