public class OutOfSpaceException extends Exception {
    private String text;
    
    public OutOfSpaceException(String text) {
        this.text = text;
    }
    
    public OutOfSpaceException() {
        this.text = "Impossible to add content. This paper is out of space.";
    }
    
    public String toString() {
        return "OutOfSpaceException: " + this.text;
    }
    
    public String getMessage() {
        return this.text;
    }
}
