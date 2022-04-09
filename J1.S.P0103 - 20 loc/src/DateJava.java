
public class DateJava {
    private int day;
    private int month;
    private int year;

    public DateJava(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DateJava() {
    }
    
    public String CompareToDate(DateJava secondDate){
        // check if year of secondDate is greater than base year or not
        if (secondDate.year > year) {
            return "before";
        }
        // check if it is equal or not
        else if (secondDate.year == year) {
            // check if month of secondDate is greater than base month or not
            if (secondDate.month > month) {
                return "before";
            }
            // check if it is equal or not
            else if (secondDate.month == month){
                // check if day of secondDate is greater than base day or not
                if (secondDate.day > day) {
                    return "before";
                }
                //check if it is equal or not
                else if (secondDate.day == day) {
                    return "equal";
                }
                else return "behind";
            }
            else return "behind";
        }
        else return "behind";
    }
}
