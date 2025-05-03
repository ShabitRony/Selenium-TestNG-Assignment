package tests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest {


    @Test(description = "Admin Login")
    public void testAdminLogin() throws InterruptedException {
        loginPage.doLogin("admin@test.com","admin123");
    }
    @Test
    public void userLogin() throws IOException, ParseException, InterruptedException {
        // Fetching user credentials from the JSON file
        String[] credentials = LoginPage.getUserCredentials();
        String email = credentials[0];
        String password = credentials[1];

        // Performing the login action
        loginPage.doLogin(email, password);

        // Waiting for the next page load
        Thread.sleep(2000);

        // Clicking a button after login
        List<WebElement> btnCost = driver.findElements(By.tagName("button"));
        btnCost.get(1).click();
    }

//    public void userLogin() throws IOException, ParseException, InterruptedException {
//        JSONParser parser = new JSONParser();
//        JSONArray jsonArray =(JSONArray) parser.parse(new FileReader("./src/test/resources/users.json"));
//        JSONObject jsonObject =(JSONObject)jsonArray.get(jsonArray.size()-1);
//        String email =jsonObject.get("email").toString();
//        String password = jsonObject.get("password").toString();
//        loginPage.doLogin(email,password);
//
//        Thread.sleep(2000);
//        List<WebElement> btnCost =  driver.findElements(By.tagName("button"));
//        btnCost.get(1).click();
//
//    }


}
