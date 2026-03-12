import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    static void deleteStudent(HashSet<Student> set) {
        Iterator<Student> iterator = set.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    static void transferStudent(HashSet<Student> set) {
        for(Student student : set) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    static void printStudents(Set<Student> students, int course) {
        for(Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student("Иван Петров", "ИС-21", 3, new int[]{5, 5, 4, 5}));
        set.add(new Student("Мария Соколова", "ПИ-22", 1, new int[]{4, 3, 4, 3}));
        set.add(new Student("Алексей Новиков", "КБ-20", 2, new int[]{2, 2, 1, 2}));
        set.add(new Student("Дмитрий Волков", "КБ-20", 2, new int[]{4, 3, 4, 3}));
    
        deleteStudent(set);
        transferStudent(set);
        printStudents(set, 3);
    }
}