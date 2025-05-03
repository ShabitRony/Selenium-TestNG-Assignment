//package tests;
//
//import config.Setup;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import page.ResetPassword;
//
//import java.io.FileReader;
//import java.io.IOException;
//
//
//public class ResetPasswordTestRunner extends Setup
//{
////    @Test(priority = 1, description = "Reset with Wrong Password")
//    public void resetWithWrongPassword(){
//        driver.findElement(By.partialLinkText("Reset it here")).click();
//        ResetPassword resetPassword = new ResetPassword(driver);
////        String email = ("shabitalahi123+03@gmail.com");
////        UserModel userModel =new UserModel();
////        userModel.setEmail(email);
////
////        resetPassword.resetPassword(userModel);
//        resetPassword.resetPassword("shabitalahi123+03@gmail.com");
//        String actualMessage =driver.findElement(By.tagName("p")).getText();
//        System.out.println(actualMessage);
//        String expectedMessgae = "Your email is not registered";
//        Assert.assertTrue(actualMessage.equals(expectedMessgae));
//    }
////    @Test(priority = 2, description = "Reset with Empty Field")
//    public void resetWithEmptyField(){
//        driver.findElement(By.partialLinkText("Reset it here")).click();
//        String isRequired =driver.findElement(By.tagName("input")).getAttribute("required");
//        driver.findElement(By.tagName("button")).click();
//        Assert.assertNotNull(isRequired, "Email field should have 'required' attribute.");
//    }
//    @Test(description = "Reset Password")
//    public void resetPasswordWithValidEmail() throws ParseException, IOException, InterruptedException {
//        driver.findElement(By.partialLinkText("Reset it here")).click();
//        ResetPassword reset = new ResetPassword(driver);
//        JSONParser parser =new JSONParser();
//        JSONArray jsonArray = (JSONArray)parser.parse(new FileReader("./src/test/resources/users.json"));
//        JSONObject userObj =(JSONObject) jsonArray.get(jsonArray.size()-1);
//        String email = userObj.get("email").toString();
//
//        reset.resetPassword(email);
////        Thread.sleep(5000);
//        String actualMessage =driver.findElement(By.tagName("p")).getText();
//        System.out.println(actualMessage);
//        String expectedMessgae = "Password reset link sent to your email";
//        Assert.assertTrue(actualMessage.equals(expectedMessgae));
//
//
//
////        Thread.sleep(5000);
////        driver.navigate().to("https://dailyfinance.roadtocareer.net/reset-password?token=d3b2495f092dc26bbad76f0c54be0e5c3e1be7dd39052bdde1b8ea0128f33ec6");
////        List<WebElement> txtinput = driver.findElements(By.tagName("input"));
////        txtinput.get(0).sendKeys("1234");
////        txtinput.get(1).sendKeys("1234");
////        driver.findElement(By.tagName("button")).click();
//    }
//
//}
