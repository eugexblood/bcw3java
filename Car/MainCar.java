public class MainCar {
    public static void main(String[] args) throws CloneNotSupportedException, TooMuchFuelException, OutOfFuelException {
        Point a = new Point(3, 8);
        Car mrs = new Car();
        Car mzd = new Car(50, 0.63, a, "Mazda");
        
        System.out.println(a);
        
        mrs.show();
        mzd.show();
        
        mrs.refill(3);
        try {
            mzd.refill(75);
        } catch (TooMuchFuelException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            mrs.drive(a);
        } catch (OutOfFuelException e) {
            System.out.println(e);
        }
        mzd.drive(20, 12);
    }
}
