public class EmployeeTest { 
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1,11,1993);

        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        System.out.println("");

        System.out.println("Antonio Rossi vs Isabel Vidal: " + staff[0].compare(staff[2])); 
        System.out.println("Maria Bianchi vs Maria Bianchi: " + staff[1].compare(staff[1])); 
        System.out.println("Isabel Vidal vs Antonio Rossi: " + staff[2].compare(staff[0])); 

        System.out.println("");
        System.out.println("Mengurutkan dari gaji tertinggi ke terendah: ");
        for (int i = 0; i < staff.length - 1; i++) {
            for (int j = 0; j < staff.length - i - 1; j++) {
                if (staff[j].compare(staff[j + 1]) < 0) {
                    Employee temp = staff[j];
                    staff[j] = staff[j + 1];
                    staff[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < staff.length; i++) {
            staff[i].print();
        }
    }
}