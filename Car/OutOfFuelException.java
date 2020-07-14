public class OutOfFuelException extends Exception {
    private double distance;
    private double fuelAmount;
    private double fuelNeeded;
    
    public OutOfFuelException(double distance, double fuelAmount, double fuelNeeded) {
        this.distance = distance;
        this.fuelAmount = fuelAmount;
        this.fuelNeeded = fuelNeeded;
    }
    
    public OutOfFuelException() {
        this(0.0, 0.0, 0.0);
    }
    
    public String toString() {
        return "OutOfFuelException: Not enough fuel to drive " + String.format("%.2f", this.distance) + " km. This car has only "
        + String.format("%.2f", this.fuelAmount) + " litres of " + String.format("%.2f", this.fuelNeeded) + " needed.";
    }
    
    public String getMessage() {
        return "Not enough fuel to drive " + String.format("%.2f", this.distance) + " km. This car has only "
        + String.format("%.2f", this.fuelAmount) + " litres of " + String.format("%.2f", this.fuelNeeded) + " needed.";
    }
}