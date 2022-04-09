
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class GetData {
    int getInt(int min, int max, String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        int number;
        // loop to get input
        do {
            System.out.print(msg);
            input = sc.nextLine();
            //check input empty
            if (input.isEmpty()) {
                System.err.println("Input cannot empty!");
                continue;
            }
            try {
                number = Integer.parseInt(input);
                // check number has value between max and min
                if (number >= min && number <= max) {
                    break;
                } else {
                    System.err.println("Input must between " + min + " and " + max);
                }
            } catch (Exception e) {
                System.err.println("Input wrong format!");
            }
        } while (true);
        return number;
    }

    String getString(String msg, String regex) {
        Scanner sc = new Scanner(System.in);
        String input;
        // loop to get input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            // check input empty
            if (input.isEmpty()) {
                System.err.println("Input cannot empty!");
                continue;
            }
            if (input.contains(";")){
                System.err.println("Input must not have ; character!");
                continue;
            }
            // check if regex is empty or not
            if (regex.isEmpty()) {
                break;
            }
            // check input match the regex
            if (input.matches(regex)) {
                break;
            } else {
                System.err.println("Input must match format!");
            }
        }
        return input;
    }

    Date getDate(String msg) {
        String input;
        Date date;
        //loop to get input
        while (true) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            /*
            [0-9]{1,2}: the number must have 1 or 2 digit number
            [-]: contain character -
            [0-9]{4}: the number must have 4 digit number 
             */
            input = getString(msg, "[0-9]{1,2}[-][0-9]{1,2}[-][0-9]{4}");
            try {
                date = dateFormat.parse(input);
                break;
            } catch (Exception e) {
                System.err.println("Date doesn't existed!");
            }
        }
        return date;
    }
    
    double getTime(String msg) {
        String input;
        double time;
        // loop to get input from user  
        while (true) {
            /*
                \\d : matches any digit character (0-9)
                + : match 1 or more of preceding token
                \\.: match a "." character
                [05]: match any character in set 0 or 5
                $: match the end of string.
             */
            input = getString(msg, "\\d+\\.[05]$");
            //check input empty
            if (input.isEmpty()) {
                System.err.println("Input cannot empty!");
                continue;
            }
            try {
                time = Double.parseDouble(input);
                // check number has value between max and min
                if (time >= 8 && time <= 17) {
                    break;
                } else {
                    System.err.println("From time must between 8h and 17h");
                }
            } catch (Exception e) {
                System.err.println("Input wrong format!");
            }
        }
        return time;
    }
    
    double getTime(String msg, double fromValue){
        String input;
        double time;
        // loop to get input from user  
        while(true){
            /*
                \\d : matches any digit character (0-9)
                + : match 1 or more of preceding token
                \\.: match a "." character
                [05]: match any character in set 0 or 5
                $: match the end of string.
            */
            input = getString(msg, "\\d+\\.[05]$");
            //check input empty
            if (input.isEmpty()) {
                System.err.println("Input cannot empty!");
                continue;
            }
            try {
                time = Double.parseDouble(input);
                // check number has value between max and min
                if (time > fromValue && time <= 17.5) {
                    break;
                } else {
                    System.err.println("To time must between from time and 17.5h");
                }
            } catch (Exception e) {
                System.err.println("Input wrong format!");
            }
        }
        return time;
    }
    
    String getTaskName(String msg){
        int taskType = getInt(1, 4, "Task type: ");
        String taskName = "";
        // compare value of task type to get task name
        switch(taskType){
            case 1:
                taskName = "Code";
                break;
            case 2:
                taskName = "Test";
                break;
            case 3: 
                taskName = "Design";
                break;
            case 4:
                taskName = "Review";
                break;
        }
        return taskName;
    }
}
