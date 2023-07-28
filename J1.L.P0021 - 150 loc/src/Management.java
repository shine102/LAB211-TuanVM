
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Management {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final DataValidation DATA_VALIDATION = new DataValidation();
    private static final Map<Integer, String> COURSE = new HashMap<>();
    private static ArrayList<StudentSchedule> STUDENTLIST;

    static{
        COURSE.put(1, "Java");
        COURSE.put(2, ".NET");
        COURSE.put(3, "C/C++");
        STUDENTLIST = new ArrayList<>();
    }

    boolean checkDuplicate(int ID, String studentName, int semester, String course) {
        // loop through every element in list
        for (StudentSchedule s : STUDENTLIST) {
            // check if id equal but the name is not equal 
            if (s.getID() == ID && !s.getStudentName().equals(studentName)) {
                return true;
            }
            // check if id is equal and the semester, course is equal too
            if (s.getID() == ID && s.getSemester() == semester && s.getCourse() == course) {
                return true;
            }
        }
        return false;
    }

    public void create() {
        System.out.println("====================== Add =====================");
        // check if the list is empty or not
        if (!STUDENTLIST.isEmpty()) {
            Display.displayAll(STUDENTLIST);
        }
        // loop until user choose stop 
        while (true) {
            // loop to get 10 students
            for (int i = 0; i < 10; i++) {
                System.out.println("Please enter student " + (i + 1) + " info!");
                int ID = DATA_VALIDATION.validateInt(SCANNER, 1, Integer.MAX_VALUE, "ID: ");
                /*
                    \\w: matches any word character 
                    \\s: matches any whitespace character
                    *: match 0 or more of the preceding token
                 */
                String studentName = DATA_VALIDATION.validateString(SCANNER, "Student name: ", "\\w*\\s*");
                int semester = DATA_VALIDATION.validateInt(SCANNER, 1, Integer.MAX_VALUE, "Semester: ");
                int courseID = DATA_VALIDATION.validateInt(SCANNER, 1, 3, "Enter course id (1-Java 2-.Net 3-C/C++): ");
                String course = COURSE.get(courseID);
                // check if the student is duplicated or not
                if (!checkDuplicate(ID, studentName, semester, course)) {
                    STUDENTLIST.add(new StudentSchedule(ID, studentName, semester, course));
                } else {
                    System.err.println("Duplicated! Please enter another one!");
                    i--;
                }
                System.out.println("--------------------------------------------");
            }
            String choice = DATA_VALIDATION.validateString(SCANNER, "Do you want to continue (Y/N)?", "[YNyn]");
            // check if the value of choice equal to n
            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void findSort() {
        System.out.println("==================== Find and Sort ===================");
        String nameToSearch = DATA_VALIDATION.validateString(SCANNER, "Enter name or part of name your want to search: ", "");
        ArrayList<StudentSchedule> listSearchByName = findByName(nameToSearch);
        // check if the list is not null
        if (listSearchByName != null) {
            Collections.sort(listSearchByName);
            System.out.println("Result: ");
            Display.displayAll(listSearchByName);
        } else {
            System.out.println("Cannot find any student with that name!");
        }
    }

    ArrayList<StudentSchedule> findByName(String nameToSearch) {
        boolean flag = false;
        ArrayList<StudentSchedule> listSearchByName = new ArrayList<>();
        // loop through every element in list
        for (StudentSchedule s : STUDENTLIST) {
            // check if the student name is contain the name to search or not
            if (s.getStudentName().contains(nameToSearch)) {
                listSearchByName.add(s);
                flag = true;
            }
        }
        // check if the flag is true or false
        if (!flag) {
            return null;
        } else {
            return listSearchByName;
        }
    }

    ArrayList<StudentSchedule> findByID(int ID) {
        boolean flag = false;
        ArrayList<StudentSchedule> listSearchByID = new ArrayList<>();
        // loop through every element in list
        for (StudentSchedule s : STUDENTLIST) {
            // check if the id in parameter is equal to id of student scheldule or not 
            if (s.getID() == ID) {
                listSearchByID.add(s);
                flag = true;
            }
        }
        // check if the flag is true or false
        if (!flag) {
            return null;
        } else {
            return listSearchByID;
        }
    }
    
    void updateName(String nameBefore, String nameAfter){
        // loop through every element in list
        for (StudentSchedule s : STUDENTLIST){
            // if the name of s equal to nameBefore
            if (s.getStudentName().equalsIgnoreCase(nameBefore)){
                s.setStudentName(nameAfter);
            }
        }
    }

    public void updateDelete() {
        
        System.out.println("================= Update / Delete ==================");
        int ID = DATA_VALIDATION.validateInt(SCANNER, 1, Integer.MAX_VALUE, "Enter student ID to find: ");
        String choice = DATA_VALIDATION.validateString(SCANNER, "Do you want to update (U) or "
                + "delete (D) student: ", "[DUdu]");
        ArrayList<StudentSchedule> listSearchByID = findByID(ID);
        // check if the value of choice is u or U
        if (choice.equalsIgnoreCase("u")){
            // TODO: update
            System.out.println("Updating...");
            if (listSearchByID == null){
                System.out.println("Can not find any student with that ID");
                return;
            } else {
                Display.displayAll(listSearchByID);
            }
            int index = DATA_VALIDATION.validateInt(SCANNER, 1, listSearchByID.size(), "Choose what record to update, type number: ") - 1;
            StudentSchedule ss = listSearchByID.get(index);
            System.out.println("1. Update semester.");
            System.out.println("2. Update course.");
            System.out.println("3. Update ID.");
            System.out.println("4. Update name.");
            int c = DATA_VALIDATION.validateInt(SCANNER, 1, 4, "Enter your choice: ");
            
            switch(c){
                case 1:
                    int semester = DATA_VALIDATION.validateInt(SCANNER, 1, Integer.MAX_VALUE, "Enter new semester: ");
                    // check if the result of function checkDuplicate is true or false 
                    if (!checkDuplicate(ss.getID(), ss.getStudentName(), semester, ss.getCourse())) {
                        ss.setSemester(semester);
                    } else {
                        System.out.println("Duplicate value! Please do again!");
                    }
                    break;
                case 2:
                    int courseID = DATA_VALIDATION.validateInt(SCANNER, 1, 3, "Enter course id (1-Java 2-.Net 3-C/C++): ");
                    String course = "";
                    // give course value base on value of courseID
                    switch (courseID) {
                        case 1:
                            course = "Java";
                            break;
                        case 2:
                            course = ".NET";
                            break;
                        case 3:
                            course = "C/C++";
                            break;
                    }
                    // check if the result of function checkDuplicate is true or false 
                    if (!checkDuplicate(ss.getID(), ss.getStudentName(), ss.getSemester(), course)) {
                        ss.setCourse(course);
                    } else {
                        System.out.println("Duplicate value! Please do again!");
                    }
                    break;
                case 3:
                    int newID = DATA_VALIDATION.validateInt(SCANNER, 1, Integer.MAX_VALUE, "Enter new ID: ");
                    // check if there is any change in the info or not
                    
                    // check if there is any duplicate or not 
                    if (!checkDuplicate(ID, ss.getStudentName(), ss.getSemester(), ss.getCourse())){
                        ss.setID(newID);
                    } else {
                        System.out.println("Duplicate value! Please do again!");
                    }
                    break;
                case 4:
                    String newName = DATA_VALIDATION.validateString(SCANNER, "Enter new name: ", "");
                    updateName(ss.getStudentName(), newName);
                    break;
            }
        } else {
            System.out.println("Deleting...");
            // check if the value of listSearchByID is null or not
            if (listSearchByID != null){
                STUDENTLIST.removeAll(findByID(ID));
                Display.displayAll(STUDENTLIST);
            } else {
                System.out.println("Cannot find any student with that ID!");
            }
        }
    }
    
    int indexInReportList(ArrayList<Report> reportList, int ID, String course){
        int index = -1;
        // check if the reportList is empty or not
        if (reportList.isEmpty()){
            return -1;
        }
        // loop throught every element is the list
        for(Report r : reportList) {
            // check if the ID is equal and the course is equal
            if (r.getID() == ID && r.getCourse() == course){
                index = reportList.indexOf(r);
                break;
            }
        }
        return index;
    }

    public void report() {
        ArrayList<Report> reportList = new ArrayList<>();
        // loop through every element of the list
        for (StudentSchedule s : STUDENTLIST){
            int index = indexInReportList(reportList, s.getID(), s.getCourse());
            // check if the index is equal to -1 or not
            if ( index == -1 ){
                reportList.add(new Report(s.getID(), s.getStudentName(), s.getCourse(), 1));
            } else {
                int total = reportList.get(index).getTotalOfCourse();
                reportList.get(index).setTotalOfCourse(total + 1);
            }
        }
        // display report
        System.out.println("Report: ");
        System.out.format("%-15s | %-10s | %-10s\n", "Student name", "Course", "Total course");
        // loop through every element is list
        for (Report r : reportList){
            System.out.format("%-15s | %-10s | %-10s\n", r.getStudentName(), r.getCourse(), r.getTotalOfCourse());
        }
        
    }
    
}
