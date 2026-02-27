public class Main {
    public static void main(String[] args) {
    
        /* TEST SHAPE */
        Shape s1 = new Shape();
        System.out.println(s1);

        Shape s2 = new Shape("blue", false);
        System.out.println(s2);

        System.out.println("Color s2: " + s2.getColor());
        System.out.println("Filled s2: " + s2.isFilled());

        s2.setColor("yellow");
        s2.setFilled(true);

        System.out.println("After modify:");
        System.out.println(s2);

        /* TEST CIRCLE */

        Circle2 c1 = new Circle2();
        System.out.println(c1);

        Circle2 c2 = new Circle2(5.0, "blue", false);
        System.out.println(c2);

        System.out.println("Area: " + c2.getArea());
        System.out.println("Perimeter: " + c2.getPerimeter());

        /* TEST RECTANGLE */

        Rectangle r1 = new Rectangle();
        System.out.println(r1);

        Rectangle r2 = new Rectangle(4.0, 5.0, "blue", false);
        System.out.println(r2);

        System.out.println("Area: " + r2.getArea());
        System.out.println("Perimeter: " + r2.getPerimeter());

        /* TEST SQUARE */
        
        Square p1 = new Square(4);
        System.out.println(p1);

        System.out.println("Area: " + p1.getArea());
        System.out.println("Perimeter: " + p1.getPerimeter());

        p1.setSide(6);
        System.out.println("After setSide:");
        System.out.println(p1);

        p1.setWidth(8);
        System.out.println("After setWidth:");
        System.out.println(p1);
    
    }
}