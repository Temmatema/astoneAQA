package task_1;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>(Set.of(
                new Student("Иван Петров", "ИС-21", 3, new int[]{5, 5, 4, 5}),
                new Student("Мария Соколова", "ПИ-22", 1, new int[]{4, 3, 4, 3}),
                new Student("Алексей Новиков", "КБ-20", 2, new int[]{2, 2, 1, 2}),
                new Student("Дмитрий Волков", "КБ-20", 2, new int[]{4, 3, 4, 3})
        ));

        StudentService serv = new StudentService(students);

        serv.removeFailedStudents();
        serv.promoteStudents();
        serv.printStudentsByCourse(3);
    }
}