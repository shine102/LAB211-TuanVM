
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class Management {
    
    boolean checkDuplicatedID(ArrayList<Employee> elist, int id){
        // loop through every element of the list
        for (Employee ite : elist){
            // check if the value of id of e is equal to id or not
            if (ite.getId() == id){
                return true;
            }
        }
        return false;
    }
    
    void addEmployee(ArrayList<Employee> elist) throws InterruptedException {
        Validation validate = new Validation();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-------- Add employee --------\n");
        // check if the list is empty or not
        if (!elist.isEmpty()){
            Display.displayAllEmployee(elist);
        }
        int id;
        // loop to get id
        while(true) {
            id = validate.validateInt(sc, 1, Integer.MAX_VALUE, "Enter the ID: ");
            // check if the id is duplicated or not
            if (!checkDuplicatedID(elist, id)){
                break;
            } else {
                System.err.println("Duplicated id, please enter again!");
                Thread.sleep(500);
            }
        }

        String firstName = validate.validateString(sc, "", "Enter first name: ");
        String lastName = validate.validateString(sc, "", "Enter last name: ");
        /*
        ^: start with
        [9853]{1}: match character in 9,8,5,3 one time
        [0-9]{8}: match number from 0 to 9 8 times
        $: end with
         */
        String phone = validate.validateString(sc, "^0[9853]{1}[0-9]{8}$", "Enter phone number: ");
        /*
        ^: start with
        [a-zA-Z0-9]+: match at least one time with character from a to z, from A to Z, from 0 to 9
        [a-z]+: match at least one time with character from a to z
        \\.: match with character .
        $: end with
         */
        String email = validate.validateString(sc, "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$", "Enter email: ");
        String address = validate.validateString(sc, "", "Enter address: ");
        //[FMfm]{1}: match with F or M or f or m one time
        String sex = validate.validateString(sc, "[FMfm]{1}", "Enter sex (F:female, M:male): ");
        Date dob;
        // loop to get date of birth
        while (true) {
            dob = validate.validateDate(sc, "Enter date of birth [dd/MM/yyyy]: ");
            Date now = new Date();
            // compare date of birth to today
            if (dob.after(now)) {
                System.out.println("Birthday must before today");
            } else {
                break;
            }
        }
        String agency = validate.validateString(sc, "", "Enter agency: ");
        int salary = validate.validateInt(sc, 0, Integer.MAX_VALUE, "Enter salary (must be integer): ");
        elist.add(new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency));
    }
    
    Employee findEmployeeById(int id, ArrayList<Employee> elist){
        // loop through every element in list
        for (Employee e : elist){
            // check if the id is equal or not
            if (id == e.getId()){
                return e;
            }
        } 
        return null;
    }

    void updateEmployee(ArrayList<Employee> elist) throws InterruptedException {
        Validation validate = new Validation();
        Scanner sc = new Scanner(System.in);
        // check if the list is empty or not
        if (!elist.isEmpty()) {
            System.out.println("\n-------- Update employee --------\n");
            Display.displayAllEmployee(elist);
        } else {
            System.err.println("There is no record to update!");
            return;
        }
        
        int id = validate.validateInt(sc, 1, Integer.MAX_VALUE, "Enter id to update: ");
        Employee updateEmployee = findEmployeeById(id, elist);
        // check if the value of updateEmployee is null or not
        if (updateEmployee != null){
            Display.displayUpdateMenu();
            int choice = validate.validateInt(sc, 0, 9, "Please choose one to update: ");
            switch (choice) {
                case 0:
                    int newId;
                    while (true) {
                        newId = validate.validateInt(sc, 1, Integer.MAX_VALUE, "Enter id: ");
                        // check if duplicate id or not
                        if (checkDuplicatedID(elist, newId)) {
                            // check if the duplicate id is the original id or not
                            if (updateEmployee.getId() == newId) {
                                updateEmployee.setId(newId);
                                break;
                            }
                            System.out.println("Id is duplicated!");
                        } else {
                            updateEmployee.setId(newId);
                            break;
                        }
                    }
                    break;
                case 1:
                    String firstName = validate.validateString(sc, "", "Enter first name: ");
                    updateEmployee.setFirstName(firstName);
                    break;
                case 2:
                    String lastName = validate.validateString(sc, "", "Enter last name: ");
                    updateEmployee.setLastName(lastName);
                    break;
                case 3:
                    /*
                    ^: start with
                    [9853]{1}: match character in 9,8,5,3 one time
                    [0-9]{8}: match number from 0 to 9 8 times
                    $: end with
                     */
                    String phoneNumber = validate.validateString(sc, "Enter phone number: ", "^0[9853]{1}[0-9]{8}$");
                    updateEmployee.setPhone(phoneNumber);
                    break;
                case 4:
                    /*
                    ^: start with
                    [a-zA-Z0-9]+: match at least one time with character from a to z, from A to Z, from 0 to 9
                    [a-z]+: match at least one time with character from a to z
                    \\.: match with character .
                    $: end with
                     */
                    String email = validate.validateString(sc, "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$", "Enter email: ");
                    updateEmployee.setEmail(email);
                    break;
                case 5:
                    String address = validate.validateString(sc, "", "Enter address: ");
                    updateEmployee.setAddress(address);
                    break;
                case 6:
                    Date dob = validate.validateDate(sc, "Enter date of birth: ");
                    updateEmployee.setDob(dob);
                    break;
                case 7:
                    //[FMfm]{1}: match with F or M or f or m one time
                    String sex = validate.validateString(sc, "[FMfm]{1}", "Enter sex (F:female, M:male): ");
                    updateEmployee.setSex(sex);
                    break;
                case 8:
                    int salary = validate.validateInt(sc, 0, Integer.MAX_VALUE, "Enter salary (must be integer): ");
                    updateEmployee.setSalary(salary);
                    break;
                case 9:
                    String agency = validate.validateString(sc, "", "Enter agency: ");
                    updateEmployee.setAgency(agency);
                    break;
            }
            // check if the list is empty or not
            if (!elist.isEmpty()) {
                Display.displayAllEmployee(elist);
            }
        } else {
            System.err.println("Cannot find any employee having that id!");
            Thread.sleep(500);
        } 
        
    }

    void removeEmployee(ArrayList<Employee> elist) throws InterruptedException {
        Validation validate = new Validation();
        Scanner sc = new Scanner(System.in);
        // check if the list is empty or not
        if (!elist.isEmpty()) {
            System.out.println("\n-------- Delete employee --------\n");
            Display.displayAllEmployee(elist);
        } else {
            System.err.println("There is no record to delete!");
            return;
        }
        int deleteID = validate.validateInt(sc, 1, Integer.MAX_VALUE, "Enter id to delete: ");
        Employee deleteEmployee = findEmployeeById(deleteID, elist);
//        check if the value of deleteEmployee is null or not
        if (deleteEmployee != null){
            elist.remove(deleteEmployee);
            // check if the list is empty or not
            if (!elist.isEmpty()) {
                Display.displayAllEmployee(elist);
            }
        } else {
            System.err.println("Cannot find any employee having that id!");
            Thread.sleep(500);
        }
    }

    void searchEmployee(ArrayList<Employee> elist) {
        Validation validate = new Validation();
        Scanner sc = new Scanner(System.in);
        int check = 0;
        // check if the list is empty or not
        if (!elist.isEmpty()) {
            System.out.println("\n--------- Search employee ---------\n");
            String nameToSearch = validate.validateString(sc, "", "Enter the name or part of name to search: ");
            boolean flag = false;
            // loop through elements in list
            System.out.println("Find result: ");
            for(Employee e : elist){
                String name = e.getFirstName() + " " + e.getLastName();
                // check if contain or not
                if (name.contains(nameToSearch)){
                    flag = true;
                    // check the value of check is equal to 0 or not
                    if (check == 0){
                        System.out.format("%-4s | %-12s | %-12s | %-11s | %-14s | %-14s | %-10s | %-4s | %-10s | %-15s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
                        check ++;
                    }
                    Display.displayEmployee(e);
                }
            }
            if (!flag){
                System.err.println("Cannot find any name suitable!");
            }
        } else {
            System.err.println("There is no record to search");
            return;
        }
    }

    void sort(ArrayList<Employee> elist) {
        // check if the list is empty or not
        if (!elist.isEmpty()) {
            Collections.sort(elist);
            Display.displayAllEmployee(elist);
        } else {
            System.err.println("The list is empty!");
        }
    }
    
    
    
}
