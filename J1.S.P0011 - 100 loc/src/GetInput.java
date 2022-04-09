
import java.util.Scanner;


public class GetInput {
    // get base
    int getBase (Scanner sc, String type){
        int base;
        // loop to get input
        while(true){
            // check if type equal in
            if ("in".equals(type)){
                System.out.print("Enter base input: ");
            } else {
                System.out.print("Enter base output: ");
            }
            try {
                base = Integer.parseInt(sc.nextLine());
                // check if base equal 2, 10 or 16
                if (base == 2 || base == 10 || base == 16){
                    break;
                } else {
                    System.out.println("Base entered must be 2, 10 or 16!!!");
                }
            } catch (Exception e){
                System.out.println("Base entered must be 2, 10 or 16!!!");
            }
        }
        return base;
    }
    
    // get number
    String getNumber (Scanner sc, int type){
        String input = "";
        switch (type) {
            case 2:
                // loop to get number 
                while (true) {
                    System.out.print("Enter number base 2: ");
                    input = sc.nextLine();
                    // [01]+: match at least one time 0 or 1
                    // check input match with the regex
                    if (input.matches("[01]+")){
                        break;
                    } else {
                        System.out.println("Number enter must be correct base 2!");
                    }
                }   
                break;
            case 10:
                while (true) {
                    System.out.print("Enter number base 10: ");
                    input = sc.nextLine();
                    // [0-9]+: match at least one time digit from 0 to 9
                    // check if input match with regex or not
                    if (input.matches("[0-9]+")) {
                        break;
                    } else {
                        System.out.println("Number enter must be correct base 10!");
                    }
                }
                break;
            case 16:
                while (true) {
                    System.out.print("Enter number base 16: ");
                    input = sc.nextLine();
                    // [0-9A-F]+: match at least one time digit from 0 to 9 or A to F
                    // check if input match with regex or not
                    if (input.matches("[0-9A-F]+")) {
                        break;
                    } else {
                        System.out.println("Number enter must be correct base 16!");
                    }
                }
                break;
        }
        return input;
    }
}
