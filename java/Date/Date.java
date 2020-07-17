public class Date implements Cloneable{
    private int day;
    private int month;
    private int year;
    
    public Date(int day, int month, int year) throws InvalidDateException {
        this.day = day;
        this.month = month;
        this.year = year;
        this.validate(day, month, year);
    }
    
    public Date() throws InvalidDateException {
        this(1, 1, 1970);
    }
    
    private void validate(int day, int month, int year) throws InvalidDateException {
        if ( year < 1900 ) {
            throw new InvalidDateException("Year value should be >= 1900.");
        }
        if ( month < 1 || month > 12 ) {
            throw new InvalidDateException("Month value should be from 1 to 12.");
        }
        if ( day < 1 ) {
            throw new InvalidDateException("Day value shouldn't be negative.");
        }
        if ( month == 2 ) {
            if ( year % 4 == 0 ) {
                if ( day > 29 ) {
                    throw new InvalidDateException("It is only 29 days in February this year.");
                }
            } else if ( day > 28 ) {
                throw new InvalidDateException("It is only 28 days in February this year.");
            }
            return;
        }
        if ( month == 1 || month == 4 || month == 6 || month == 9 || month == 11 ) {
            if ( day > 30 ) {
                throw new InvalidDateException("It is only 30 days in this month.");
            }
        } else if ( day > 31 ) {
            throw new InvalidDateException("It is only 31 days in this month.");
        }
    }
    
    public int getDay() {
        return this.day;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
    
    public Date clone() throws CloneNotSupportedException {
        return (Date) super.clone();
    }
}
