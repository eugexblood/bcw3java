public class OutOfInkException extends Exception {
    private String text;
    
    public OutOfInkException(String text) {
        this.text = text;
    }
    
    public OutOfInkException() {
        this.text = "Impossible to write. This pen is out of ink.";
    }
    
    public String toString() {
        return "OutOfInkException: " + this.text;
    }
    
    public String getMessage() {
        return this.text;
    }
}
