public class Circle2 extends Shape {
    private double radius;

    public Circle2() {
        this.radius = 1.0;
    }

    public Circle2(double radius) {
        this.radius = radius;
    }

    public Circle2(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0 ) {
            this.radius = radius;
        } else {
            System.out.println("Radius harus lebih dari 0");
        }
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
         return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
    }
}
