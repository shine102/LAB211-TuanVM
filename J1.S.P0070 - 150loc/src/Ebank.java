
import java.util.Random;
import java.util.Scanner;

public class Ebank {
    
    public boolean checkAccountNumber(String accountNumber){
        // check if the value of accountNumber is existed in account list or not
        if (Account.accountList().containsKey(accountNumber)) return true;
        return false;
    }
    
    public boolean checkPassword(String password, String accountNumber){
        // check if the value of accountNumber is existed in account list or not
        // and the password of that account is equal to value of password or not
        if (Account.accountList().containsKey(accountNumber) && Account.accountList().get(accountNumber).equals(password)) return true;
        return false;
    }
    
    public String generateCaptcha(){
        String captcha = "";
        String dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        Random rd = new Random();
        // loop to generate captcha with length equal 5
        for (int i = 0; i < 5; i++){
            captcha = captcha + dict.charAt(rd.nextInt(dict.length() - 1));
        }
        return captcha;
    }
    
    public void checkCaptcha(Scanner sc, String msg, String alert, String annouce){
        Validation validate = new Validation();
        String captchaGen = generateCaptcha();
        /*
            [a-zA-Z0-9]: match any character in the set 
            a-z range: match a character in range "a" to "z"
            A-Z range: match a character in range "A" to "Z"
            0-9 range: match a character in range 0 to 9
            {5}:match 5 of the preceding token
        */
        while(true){
            System.out.println(annouce + captchaGen);
            String captchaInput = validate.validateString(sc, msg, "", "");
            // check value of generating captcha and inputed captcha
            if (!captchaGen.equals(captchaInput)) {
                System.out.println(alert);
                captchaGen = generateCaptcha();
            } else {
                break;
            }
        }
         
               
    }
}
