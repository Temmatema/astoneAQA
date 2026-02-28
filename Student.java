public class Student {
    private String name;
    private String group;
    private int course;
    private int[] grades;

    Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getGroup() {
        return this.group;
    }

    public String getName() {
        return this.name;
    }

    public int getCourse() {
        return this.course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        double sum = 0;
        
        for(int grade : grades) {
            sum += grade;
        }

        return sum / grades.length;
    }
}
