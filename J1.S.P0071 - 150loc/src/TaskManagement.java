
import java.util.ArrayList;
import java.util.Date;


public class TaskManagement {

    GetData getData = new GetData();
    boolean checkCollideTask(ArrayList<Task> tList, Date date, String assignee, double from, double to){
        boolean isCollide = false;
        // loop through every task in task list
        for(Task t: tList){
            //check if assignee name is equal and if it is same day or not
            if (t.getAssignee().equals(assignee) && t.returnDate().equals(date)){
                // compare from time and to time to task in list
                // to time compare to from time from list, from time compare to to time from list
                if ((to < t.getFrom()) || (from > t.getTo())){
                    isCollide = false;
                }
                else {
                    return true;
                }
            }
        }
        return isCollide;
    }
    
    public void addTask(ArrayList<Task> tList, int[] lastIndex) {
        System.out.println("--------------Add Task--------------");
        String requireName = getData.getString("Requirement Name: ", "");
        String taskName = getData.getTaskName("Task type: ");
        Date date = getData.getDate("Date: ");
        double from = getData.getTime("From: ");
        double to = getData.getTime("To: ", from);
        String assignee = getData.getString("Assignee: ", "");
        String reviewer = getData.getString("Reviewer: ", "");
        if (checkCollideTask(tList, date, assignee, from, to)){
            System.err.println("Task cannot be added because the collide in assignee, time or date!!!");
        }
        else {
            try {
                lastIndex[0] = lastIndex[0] + 1;
                tList.add(new Task(lastIndex[0], requireName, taskName, date, from, to, assignee, reviewer));
            } catch (Exception e){
                tList.add(new Task(1, requireName, taskName, date, from, to, assignee, reviewer));
            }
        }
        
    }

    public void getDataTasks(ArrayList<Task> tList) {
        Display.displayTask(tList);
    }

    public void deleteTask(ArrayList<Task> tList) {
        // check task list is empty or not
        if (tList.isEmpty()){
            System.err.println("List is empty, not have any task to delete!");
            return;
        }
        System.out.println("------------------Del Task-----------------");
        int taskId = getData.getInt(1, Integer.MAX_VALUE, "ID: ");
        int indexInList = -1;
        // loop through every task in task list
        for (Task t : tList){
            // check if the id input is equal to task id
            if (taskId == t.getId()){
                indexInList = tList.indexOf(t);
            }
        }
        // check if the index in list is different again -1
        if (indexInList != -1){
            tList.remove(indexInList);
        }
        else {
            System.err.println("Id is not exist!");
        }
    }

    
}
