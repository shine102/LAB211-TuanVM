import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author la
 */
public class LoginSystem {
    void vietnamese(){
        Locale vietnam = new Locale("vi");
        loginSystem(vietnam);
    }
    
    void english(){
        Locale english = new Locale("en");
        loginSystem(english);
    }
    
    private void loginSystem(Locale locale){
        Scanner sc = new Scanner(System.in);
        Validation validate = new Validation();
        Ebank eb = new Ebank();
        ResourceBundle rb = ResourceBundle.getBundle("lang", locale);
        /*
            \\d: matches any digit character(0-9)
            {10}:match 10 of the preceding token
        */
        String accountNumber = validate.validateString(sc, rb.getString("AccountNumber"), "\\d{10}", rb.getString("AccountNumberAlert"));
        String password = validate.validatePassword(sc, rb.getString("Password"), rb.getString("PasswordAlert"));

        eb.checkCaptcha(sc, rb.getString("InputCaptcha"), rb.getString("CaptchaAlert"), rb.getString("Captcha"));
        
        boolean checkAccount = eb.checkAccountNumber(accountNumber);
        boolean checkPassword = eb.checkPassword(password, accountNumber);
        
        // check value of checkAccount and checkPassword is true or false
        if (checkAccount && checkPassword){
            System.out.println(rb.getString("LoginSuccess"));
        } else {
            System.out.println(rb.getString("LoginFail"));
        }
        
    }
}
