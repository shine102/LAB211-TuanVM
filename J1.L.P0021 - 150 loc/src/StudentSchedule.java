public class StudentSchedule implements Comparable<StudentSchedule> {
    private int ID;
    private String studentName;
    private int semester;
    private String course;

    public StudentSchedule(int ID, String studentName, int semester, String course) {
        this.ID = ID;
        this.studentName = studentName;
        this.semester = semester;
        this.course = course;
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public int compareTo(StudentSchedule o) {
        return this.studentName.compareTo(o.studentName);
    }
}
