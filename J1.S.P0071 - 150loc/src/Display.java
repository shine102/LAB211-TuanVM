
import java.util.ArrayList;


public class Display {
    static void displayMenu(){
        System.out.println("========= Task program =========");
        System.out.println("  .  Add Task");
        System.out.println("  .  Delete task");
        System.out.println("  .  Display Task");
        System.out.println("  .  exit");
    }
    
    static void displayTask(ArrayList<Task> tList){
        System.out.println("------------------------------------- Task -----------------------------------");
        if (tList.isEmpty()){
            System.err.println("No task in list now!");
            return;
        }
        System.out.format("%-4s %-15s %-12s %-12s %-10s %-12s %-12s \n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for(Task t : tList){
            System.out.format("%-4s %-15s %-12s %-12s %-10s %-12s %-12s \n", t.getId(), t.getName(), t.getTaskName(), t.getDate(), t.getTo() - t.getFrom(), t.getAssignee(), t.getReviewer());
        }
    }
}
