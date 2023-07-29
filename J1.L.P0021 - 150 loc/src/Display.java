
import java.util.ArrayList;


public class Display {
    public static void displayMenu(){
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
    }
    
    public static void displayItem(StudentSchedule s, int index){
        System.out.format("%-6s | %-6s | %-15s | %-10s | %-10s\n", index , s.getID(), s.getStudentName(), s.getSemester(), s.getCourse());
    }
    
    public static void displayAll(ArrayList<StudentSchedule> studentList){
        int i = 0;
        System.out.format("%-6s | %-6s | %-15s | %-10s | %-10s\n", "", "ID", "Student name", "Semester", "Course");
        // loop through every element of the list
        for (StudentSchedule s : studentList) {
            i ++;
            displayItem(s, i);
        }
    }

    public static void displayUpdateMenu(){
        System.out.println("1. Update semester.");
        System.out.println("2. Update course.");
        System.out.println("3. Update ID.");
        System.out.println("4. Update name.");
    }
}
