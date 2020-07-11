public class Car implements Cloneable {
    private double fuelAmount;
    private double fuelCapacity;
    private double fuelConsumption;
    private Point location;
    private String model;
    
    public Car(double capacity, double consumption, Point location, String model) throws CloneNotSupportedException {
        this.fuelAmount = 0;
        this.fuelCapacity = capacity;
        this.fuelConsumption = consumption;
        this.location = location;
        this.model = model;
    }
    
    public Car() {
        this.fuelAmount = 0;
        this.fuelCapacity = 60;
        this.fuelConsumption = 0.6;
        this.location = new Point();
        this.model = "Mercedes";
    }
    
    public void show() {
        System.out.println(this.model + " is here " + this.location + ". Fuel left: " + this.fuelAmount + ".");
    }
    
    public double getFuelAmount() {
        return this.fuelAmount;
    }
    
    public double getFuelCapacity() {
        return this.fuelCapacity;
    }
    
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }
    
    public Point getLocation() {
        return this.location;
    }
    
    public String getModel() {
        return this.model;
    }
    
    public void refill(double fuel) throws TooMuchFuelException {
        double fuelShortage = this.fuelCapacity - this.fuelAmount;
        
        if ( fuel > fuelShortage ) {
            this.fuelAmount = this.fuelCapacity;
            throw new TooMuchFuelException(fuelShortage);
        }
        
        this.fuelAmount += fuel;
        System.out.println(fuel + " l successfully refilled.");
    }
    
    public void drive(double x, double y) throws OutOfFuelException {
        Point destination = new Point(x, y);
        this.drive(destination);
    }
    
    public void drive(Point destination) throws OutOfFuelException {
        double distance = destination.distance(this.location);
        double fuelNeeded = distance * this.fuelConsumption;
        
        if ( fuelNeeded > this.fuelAmount ) {
            throw new OutOfFuelException(distance, this.fuelAmount, fuelNeeded);
        }
        
        this.location = destination;
        this.fuelAmount -= fuelNeeded;
        System.out.format("%s has driven %.2f km and moved to %s.\n", this.model, distance, destination.toString());
    }
}
