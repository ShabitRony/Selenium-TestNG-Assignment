package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.bidi.script.Message;

import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


//import static jdk.jpackage.internal.WixAppImageFragmentBuilder.Id.Folder;

public class Utils {
    public static int generateNumber(int min , int max){
        double randomNumber = Math.random()*(max-min)+min;
        return (int) randomNumber;
    }

    public static void main(String[] args) {
    int number = generateNumber(1000,9999);
        System.out.println(number);
    }
    public static void saveUserData(String filePath, JSONObject jsonObject) throws IOException, ParseException {
        JSONParser parser =new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));
        jsonArray.add(jsonObject);
        FileWriter writer = new FileWriter(filePath);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }
//    public static boolean isConfirmationEmailReceived(String userEmail, String appPassword, String expectedSubject, int maxTries, int waitSeconds) {
//        int tries = 0;
//        while (tries < maxTries) {
//            try {
//                if (checkInbox(userEmail, appPassword, expectedSubject)) {
//                    return true;
//                }
//                Thread.sleep(waitSeconds * 1000L);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            tries++;
//        }
//        return false;
//    }
//
//    public static boolean isEmailWithSubjectReceived(String userEmail, String password, String expectedSubject, int retries, int waitSeconds) {
//        for (int attempt = 0; attempt < retries; attempt++) {
//            try {
//                if (checkInbox(userEmail, password, expectedSubject)) {
//                    return true;
//                }
//                Thread.sleep(waitSeconds * 1000L);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//    public static boolean checkInbox(String userEmail, String password, String expectedSubject) throws Exception {
//        Properties props = new Properties();
//        props.setProperty("mail.store.protocol", "imaps");
//
//        Session session = Session.getInstance(props);
//        Store store = session.getStore("imaps");
//        store.connect("imap.gmail.com", userEmail, password);
//
//        Folder inbox = store.getFolder("INBOX");
//        inbox.open(Folder.READ_ONLY);
//        Message[] messages = inbox.getMessages();
//
//        for (int i = messages.length - 1; i >= Math.max(0, messages.length - 10); i--) {
//            Message message = messages[i];
//            if (message.getSubject() != null && message.getSubject().toLowerCase().contains(expectedSubject.toLowerCase())) {
//                return true;
//            }
//        }
//
//        inbox.close(false);
//        store.close();
//        return false;
//    }
}



