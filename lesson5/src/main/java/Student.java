import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;
    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }
    public String getName() {
        return name;
    }
    public String getGroup() {
        return group;
    }
    public int getCourse() {
        return course;
    }
    public List<Integer> getGrades() {
        return grades;
    }
    public double getAverageGrade() {
        int sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Group 1", 1, List.of(4, 3, 5)));
        students.add(new Student("Bob", "Group 2", 2, List.of(3, 2, 4)));
        students.add(new Student("Charlie", "Group 1", 1, List.of(2, 2, 2)));
        removeStudentsWithLowAverageGrade(students);
        promoteStudents(students);
        printStudents(students, 1);
    }
    public static void removeStudentsWithLowAverageGrade(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
            }
        }
    }
    public static void promoteStudents(List<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.course++;
            }
        }
    }
    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}