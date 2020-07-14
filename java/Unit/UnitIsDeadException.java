public class UnitIsDeadException extends Exception {
    private String message;
    
    public UnitIsDeadException(String name) {
        this.message = "Action impossible. " + name + " is dead.";
    }
    
    public UnitIsDeadException() {
        this.message = "Action impossible. Unit is dead.";
    }
    
    public String toString() {
        return "UnitIsDeadException: " + this.message;
    }
    
    public String getMessage() {
        return this.message;
    }
}
