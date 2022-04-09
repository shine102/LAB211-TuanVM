
import java.util.Scanner;

public class Main {

    public static DateJava verify(String str) {
        // Check regex if str in parameter is a valid form [dd/mm/YYYY]
        // [0-9]{1,2}: the number must have 1 or 2 digit number
        // [/]: contain character /
        // [0-9]{4}: the number must have 4 digit number 
        if (str.matches("[0-9]{1,2}[/][0-9]{1,2}[/][0-9]{4}")) {
            String[] date = str.split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            // check day based on month 1,3,5,7,8,10,12
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                return verifyHelper(31, day, month, year);
            } // check day based on month 2
            else if (month == 2) {
                // check if leap year or not
                if (year % 4 == 0) {
                    return verifyHelper(29, day, month, year);
                } else {
                    return verifyHelper(28, day, month, year);
                }
            } //check day based on month 4,6,9,11
            else if (month == 4 || month == 6 || month == 9 || month == 11){
                return verifyHelper(30, day, month, year);
            }
            else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static DateJava verifyHelper(int limit, int day, int month, int year) {
        // check if day is less than or equal to limit or not
        if (day <= limit) {
            return new DateJava(day, month, year);
        } else {
            return null;
        }
    }
    
    public static void compareAndDisplay(DateJava dJ1, DateJava dJ2){
        String result = dJ1.CompareToDate(dJ2);
        // compare the result to before, equal, behind to display output
        if ("before".equals(result)) {
            System.out.println("\nDate1 is before Date2");
        } else if ("equal".equals(result)) {
            System.out.println("\nDate1 is equal Date2");
        } else {
            System.out.println("\nDate1 is behind Date2");
        }
    }
    
    public static DateJava handlingSecondDate(DateJava dJ1){
        Scanner sc = new Scanner(System.in);
        DateJava dJ2 = new DateJava();
        // loop to get input from user
        while (true){
            System.out.print("Please enter the second date: ");
            String date2 = sc.nextLine();
            dJ2 = verify(date2);
            //Check if the date is valid or not
            if (dJ2 != null) {
                break;
            } else {
                System.out.println("\nWrong date format or date not exist!");
            }
        }
        return dJ2;
    }
    
    public static DateJava handlingFirstDate(){
        Scanner sc = new Scanner(System.in);
        DateJava dtJv1 = new DateJava();
        // loop to get input from user
        while (true) {
            System.out.print("Please enter the first date: ");
            String date1 = sc.nextLine();
            dtJv1 = verify(date1);
            //Check if the date is valid or not
            if (dtJv1 != null) {
                break;
            }
            else {
                System.out.println("\nWrong date format or date not exist!");
            }
        }
        return dtJv1;
    }

    public static void main(String[] args) {
        //1. receive first date input and validate
        DateJava dJ1 = handlingFirstDate();
        //2. receive second date input and validate
        DateJava dJ2 = handlingSecondDate(dJ1);
        //3. compare and display output
        compareAndDisplay(dJ1, dJ2);
    }
}
