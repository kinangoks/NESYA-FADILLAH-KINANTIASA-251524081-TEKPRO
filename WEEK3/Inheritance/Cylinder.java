public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        this.height = 1.0;
    }
    public Cylinder (double height) {
        super();
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getBaseArea() {
        return super.getArea();
    }

    @Override
    public double getArea() {
        double r = getRadius();
        return 2 * Math.PI * r * height + 2 *super.getArea();
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Height harus lebih dari 0");
        }
    }

    @Override
    public String toString() {
        return "Cylinder[height=" + height + ", " + super.toString() + "]";
    }
    
}
