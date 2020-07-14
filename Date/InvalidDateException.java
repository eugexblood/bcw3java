public class InvalidDateException extends Exception {
    private String text;
    
    public InvalidDateException(String text) {
        this.text = text;
    }
    
    public InvalidDateException() {
        this.text = "Date input error";
    }
    
    public String toString() {
        return "InvalidDateException: " + this.text;
    }
    
    public String getMessage() {
        return this.text;
    }
}
