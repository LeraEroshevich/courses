import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "Bobka", 26));
        employees.add(new Employee("Masha", "Smith", 28));
        employees.add(new Employee("Sasha", "Smith", 36));
        employees.add(new Employee("Gena", "Bobka", 21));

        try {
            FileOutputStream fileOut = new FileOutputStream("employee.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employees);
            out.close();
            System.out.println("Serialized data is saved in employee.dat");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
