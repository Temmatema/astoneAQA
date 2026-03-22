package lesson_6.task_1;

import java.util.Set;

public class StudentService {
    private final Set<Student> students;

    public StudentService(Set<Student> students) {
        this.students = students;
    }

    public void removeFailedStudents() {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public void promoteStudents() {
        for(Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public void printStudentsByCourse(int course) {
        for(Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
