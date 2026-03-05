public abstract class Shape {
    private String shapeName;

    public Shape(String name)
    {
        this.shapeName = name;
    }

    public abstract double area();

    public String toString()
    {
        return shapeName;
    }
}
