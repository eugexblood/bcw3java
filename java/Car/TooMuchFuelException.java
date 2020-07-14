public class TooMuchFuelException extends Exception {
    private double reducedRefill;
    
    public TooMuchFuelException(double reducedRefill) {
        this.reducedRefill = reducedRefill;
        
        // next line can print message immediately as exception is thrown.
        // System.out.println("TooMuchFuelException: You tried to refill too much fuel. Only " + reducedRefill + " l refilled.");
    }
    
    public TooMuchFuelException() {
        this(0.0);
    }
    
    public String toString() {
        return "TooMuchFuelException: You tried to refill too much fuel. Only " + this.reducedRefill + " l refilled.";
    }
    
    public String getMessage() {
        return "You tried to refill too much fuel. Only " + this.reducedRefill + " l refilled.";
    }
}
