public class Complex implements Cloneable {
    private double re;
    private double im;
    
    public Complex() {
        this(0.0, 0.0);
    }
    
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    
    public double getReal() {
        return this.re;
    }
    
    public double getImaginary() {
        return this.im;
    }
    
    public boolean equals(Complex other) {
        return this.re == other.re && this.im == other.im;
    }
    
    public void increaseBy(Complex other) {
        this.re += other.re;
        this.im += other.im;
    }
    
    public void decreaseBy(Complex other) {
        this.re -= other.re;
        this.im -= other.im;
    }
    
    public Complex sum(Complex other) {
        return new Complex(this.re+other.re, this.im+other.im);
    }
    
    public Complex diff(Complex other) {
        return new Complex(this.re-other.re, this.im-other.im);
    }
    
    public Complex prod(Complex other) {
        return new Complex(this.re*other.re-this.im*other.im, this.re*other.im+this.im*other.re);
    }
    
    public String toString() {
        return String.format("%.1f%+.1fi", this.re, this.im);
    }
    
    public Complex clone() throws CloneNotSupportedException {
        return (Complex) super.clone();
    }
}
