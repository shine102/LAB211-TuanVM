
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Database {
    public ArrayList<Task> read(int [] lastIndex){
        ArrayList<Task> tList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("database.txt"));
            lastIndex[0] = Integer.parseInt(sc.nextLine());
            while(sc.hasNextLine()){
                String fileContent = sc.nextLine();
                String [] data = fileContent.split(";");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);
                int id = Integer.parseInt(data[0]);
                Date date = dateFormat.parse(data[3]);
                double from = Double.parseDouble(data[4]);
                double to = Double.parseDouble(data[5]);
                tList.add(new Task(id, data[1], data[2], date, from, to, data[6], data[7]));
            }
            sc.close();
        } catch (Exception e){
            System.err.println("Database not found or data invalid! Try to create a new one.");
            lastIndex[0] = 0;
        }
        
        return tList;
    }
    public void write(ArrayList<Task> tList, int[] lastIndex){
        try {
            FileWriter fw = new FileWriter(new File("database.txt"));
            fw.write(lastIndex[0] + "\n");
            for (Task t : tList) {
                fw.append(t.toString());
                fw.append("\n");
            }
            fw.close();
        } catch (Exception e){
            System.err.println("Error while writing to database!");
        }
        
    }
    
}
