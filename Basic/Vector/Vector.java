public class Vector implements Cloneable {
    private double x;
    private double y;
    
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector() {
        this(0.0, 0.0);
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX(double value) {
        this.x = value;
    }
    
    public void setY(double value) {
        this.y = value;
    }
    
    public double length() {
        return Math.hypot(this.x, this.y);
    }
    
    public boolean equals(Vector other) {
        return this.x == other.x && this.y == other.y;
    }
    
    public void increaseBy(Vector other) {
        this.x += other.x;
        this.y += other.y;
    }
    
    public void decreaseBy(Vector other) {
        this.x -= other.x;
        this.y -= other.y;
    }
    
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
    
    public Vector sum(Vector other) {
        return new Vector(this.x+other.x, this.y+other.y);
    }
    
    public Vector diff(Vector other) {
        return new Vector(this.x-other.x, this.y-other.y);
    }
    
    public Vector clone() throws CloneNotSupportedException {
        return (Vector) super.clone();
    }
}
