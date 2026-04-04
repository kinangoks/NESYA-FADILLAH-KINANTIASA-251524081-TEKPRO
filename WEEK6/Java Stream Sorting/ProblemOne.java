package JavaProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemOne{
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("John", 50000));
        list.add(new Employee("Rob", 70000));
        list.add(new Employee("Bob", 40000));
        list.add(new Employee("Alice", 10000));

        //Melakukan proses filtering/sorting menggunkan Stream API
        List<Employee> sortedEmp = list.stream() //[1]
            //Mengurutkan employee berdasarkan nama
            .sorted((e1,e2) -> e1.getName().compareTo(e2.getName())) //[2] &[3]
            //Mengumpulkan hasil akhir
            .collect(Collectors.toList()); //[4] & [5]

        for(Employee e : sortedEmp){
            System.out.println(e);
        }
    }
}