
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        int option;
        GetData getData = new GetData();
        Database db = new Database();
        TaskManagement tm = new TaskManagement();
        int[] lastIndex = {0};
        ArrayList<Task> tList = db.read(lastIndex);
        // loop until user end program
        while(true){
            //1. display a menu
            Display.displayMenu();
            //2. ask user to select an option
            option = getData.getInt(1, 4, "Enter your choice (1-4): ");
            //3. perform function based on the selected option
            switch(option){
                case 1: //add task
                    tm.addTask(tList, lastIndex);
                    break;
                case 2: // delete task
                    tm.deleteTask(tList);
                    break;
                case 3: // show task
                    tm.getDataTasks(tList);
                    break;
                case 4: // exit program
                    db.write(tList, lastIndex);
                    exit(0);
            }
            Thread.sleep(500);
        }
    }
}
