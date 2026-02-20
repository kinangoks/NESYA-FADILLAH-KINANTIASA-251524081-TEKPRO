package id.ac.polban.employee;

import java.util.Scanner;
import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        // Menggunakan try-with-resources agar Scanner otomatis tertutup
        try (Scanner input = new Scanner(System.in)) {
            EmployeeService service = new EmployeeService();

            System.out.println("===============================");
            System.out.println("      INPUT DATA KARYAWAN      ");
            System.out.println("===============================");

            // Input Identitas Dasar
            System.out.print("ID             : ");
            int id = input.nextInt();
            input.nextLine(); // Consume newline

            System.out.print("Nama           : ");
            String nama = input.nextLine();

            System.out.print("Departemen     : ");
            String namaDept = input.nextLine();
            
            System.out.print("Tipe Kontrak   : ");
            String tipe = input.nextLine();

            System.out.print("Gaji           : ");
            double gaji = input.nextDouble();

            // Instansiasi Objek (Relationship: Aggregation)
            Department dept = new Department(namaDept);
            EmploymentType empType = new EmploymentType(tipe);
            Employee emp = new Employee(id, nama, dept, empType, gaji);

            // Eksekusi Service (Relationship: Dependency)
            service.addEmployee(emp);

            // Output Final
            System.out.println("\n-------------------------------");
            System.out.println("Status: Data Berhasil Disimpan!");
            System.out.println("Total Karyawan: " + Employee.getTotalEmployee());
            System.out.println("-------------------------------");
            
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan input: " + e.getMessage());
        }
    }
}