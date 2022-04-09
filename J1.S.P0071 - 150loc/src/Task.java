
import java.util.Date;

public class Task {
    private int id;
    private String name;
    private String taskName;
    private Date date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public Task(int id, String name, String taskName, Date date, double from, double to, String assignee, String reviewer) {
        this.id = id;
        this.name = name;
        this.taskName = taskName;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return date.getDate() + "-" + (date.getMonth() + 1) + "-" + (date.getYear() + 1900);
    }

    public Date returnDate(){
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    public String toString(){
        return id + ";" + name + ";" + taskName + ";" + this.getDate() + ";" + from + ";" + to + ";" + assignee + ";" + reviewer;
    }
}
