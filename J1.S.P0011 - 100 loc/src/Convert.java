
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author la
 */
public class Convert {
    void convertBaseToBase(int fromBase, int toBase, String fromNumber){
        // check if fromBase equal to toBase
        if (fromBase == toBase){
            System.out.println("Output: " + fromNumber); 
            return;
        }
        switch (fromBase){
            case 16: 
                // check if toBase equal to 2
                if (toBase == 2) {
                    System.out.println("Output: " + convertDecToBin(convertHexToDec(fromNumber)));
                } else {
                    System.out.println("Output: " + convertHexToDec(fromNumber));
                }
                break;
            case 10:
                // check if toBase equal to 2
                if (toBase == 2) {
                    System.out.println("Output: " + convertDecToBin(fromNumber));
                } else {
                    System.out.println("Output: " + convertDecToHex(fromNumber));
                }
                break;
            case 2:
                // check if toBase equal to 10
                if (toBase == 10) {
                    System.out.println("Output: " + convertBinToDec(fromNumber));
                } else {
                    System.out.println("Output: " + convertDecToHex(convertBinToDec(fromNumber)));
                }
                break;
        }
    }
    
    // convert base 2 to 10 
    String convertBinToDec (String fromNumber){
        BigInteger result = new BigInteger("0");
        String [] arrFromNumber = fromNumber.split("");
        // loop from begin to end every element in array arrFromNumber
        for (int i = 0; i < arrFromNumber.length; i++) {
            BigInteger adding = new BigInteger(arrFromNumber[i]);
            adding = adding.multiply(new BigInteger("2").pow(arrFromNumber.length - i - 1));
            result = result.add(adding);
        }
        return result.toString();
    }
    
    // convert base 10 to 2
    String convertDecToBin (String fromNumber){
        String result = "";
        BigInteger fromNum = new BigInteger(fromNumber);
        // loop when fromNum isn't equal to 0
        while (!fromNum.toString().equalsIgnoreCase("0")){
            result = fromNum.mod(new BigInteger("2")).toString() + result;
            fromNum = fromNum.divide(new BigInteger("2"));
        }
        return result;
    }
    // convert base 16 to 10
    String convertHexToDec (String fromNumber){
        BigInteger result = new BigInteger("0");
        String[] arrFromNumber = fromNumber.split("");
        // loop from begin to end every element in array arrFromNumber
        for (int i = 0; i < arrFromNumber.length; i++) {
            // check if the element is equal to A or not
            if (arrFromNumber[i].equalsIgnoreCase("A")){
                BigInteger adding = new BigInteger("10");
                adding = adding.multiply(new BigInteger("16").pow(arrFromNumber.length - i - 1));
                result = result.add(adding);
            } else if (arrFromNumber[i].equalsIgnoreCase("B")) { // check if the element is equal to B or not
                BigInteger adding = new BigInteger("11");
                adding = adding.multiply(new BigInteger("16").pow(arrFromNumber.length - i - 1));
                result = result.add(adding);
            } else if (arrFromNumber[i].equalsIgnoreCase("C")) { // check if the element is equal to C or not
                BigInteger adding = new BigInteger("12");
                adding = adding.multiply(new BigInteger("16").pow(arrFromNumber.length - i - 1));
                result = result.add(adding);
            } else if (arrFromNumber[i].equalsIgnoreCase("D")) { // check if the element is equal to D or not
                BigInteger adding = new BigInteger("13");
                adding = adding.multiply(new BigInteger("16").pow(arrFromNumber.length - i - 1));
                result = result.add(adding);
            } else if (arrFromNumber[i].equalsIgnoreCase("E")) { // check if the element is equal to E or not
                BigInteger adding = new BigInteger("14");
                adding = adding.multiply(new BigInteger("16").pow(arrFromNumber.length - i - 1));
                result = result.add(adding);
            } else if (arrFromNumber[i].equalsIgnoreCase("F")) { // check if the element is equal to F or not
                BigInteger adding = new BigInteger("15");
                adding = adding.multiply(new BigInteger("16").pow(arrFromNumber.length - i - 1));
                result = result.add(adding);
            } else {
                BigInteger adding = new BigInteger(arrFromNumber[i]);
                adding = adding.multiply(new BigInteger("16").pow(arrFromNumber.length - i - 1));
                result = result.add(adding);
            }
        }
        return result.toString();
    }
    // convert base 10 to 16
    String convertDecToHex (String fromNumber){
        String result = "";
        BigInteger fromNum = new BigInteger(fromNumber);
        // loop when fromNum isn't equal to 0
        while (!fromNum.toString().equalsIgnoreCase("0")) {
            // check if the remainder when divide fromNum to 16 is equal to 10 or not
            if (fromNum.mod(new BigInteger("16")).toString().equalsIgnoreCase("10")){
                result = "A" + result;
            } // check if the remainder when divide fromNum to 16 is equal to 11 or not 
            else if (fromNum.mod(new BigInteger("16")).toString().equalsIgnoreCase("11")){
                result = "B" + result;
            } // check if the remainder when divide fromNum to 16 is equal to 12 or not 
            else if (fromNum.mod(new BigInteger("16")).toString().equalsIgnoreCase("12")){
                result = "C" + result;
            } // check if the remainder when divide fromNum to 16 is equal to 13 or not
            else if (fromNum.mod(new BigInteger("16")).toString().equalsIgnoreCase("13")){
                result = "D" + result;
            } // check if the remainder when divide fromNum to 16 is equal to 14 or not
            else if (fromNum.mod(new BigInteger("16")).toString().equalsIgnoreCase("14")){
                result = "E" + result;
            } // check if the remainder when divide fromNum to 16 is equal to 15 or not
            else if (fromNum.mod(new BigInteger("16")).toString().equalsIgnoreCase("15")){
                result = "F" + result;
            } else {
                result = fromNum.mod(new BigInteger("16")).toString() + result;
            }
            fromNum = fromNum.divide(new BigInteger("16"));
        }
        return result;
    }
    
}
