package task_1;

public abstract class Animal {
    private final String name;
    public static int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public String getName() {
        return name;
    }

    public abstract String run(int distance);
    public abstract String swim(int distance);
}