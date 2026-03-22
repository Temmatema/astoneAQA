package lesson_6.task_1;

import java.util.Arrays;

public class Student {
    private final String name;
    private final String group;
    private int course;
    private final int[] grades;

    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = Arrays.copyOf(grades, grades.length);
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        return Arrays.stream(grades).average().orElse(0);
    }
}
