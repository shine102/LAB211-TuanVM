
public class Report {
    private int ID;
    private String studentName;
    private String course;
    private int totalOfCourse;

    public Report(int ID, String studentName, String course, int totalOfCourse) {
        this.ID = ID;
        this.studentName = studentName;
        this.course = course;
        this.totalOfCourse = totalOfCourse;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }
    
    
}
