package id.ac.polban.employee.model;

public class Employee {

    private static int totalEmployee = 0; //static field untuk menghitung jumlah total employee. jumlah employee adalah milik class, bukan milik satu object.

    private int id;
    private String name;
    private Department department; //aggregation 
    private EmploymentType type; //aggregation
    private double salary;

    public Employee(int id, String name, Department department, EmploymentType type, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;
        totalEmployee++; 
    }

    public static int getTotalEmployee() { //static method untuk mengambil total employee tersebut. mengakses data static tanpa perlu membuat object.
        return totalEmployee;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Department getDepartment() {
        return department;
    }
    public EmploymentType getType() {
        return type;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}