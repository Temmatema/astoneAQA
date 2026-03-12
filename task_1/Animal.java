public abstract class Animal {
    String name;
    public static int count;

    Animal(String name) {
        this.name = name;
        count++;
    }

    public abstract String run(int distance);
    public abstract String swim(int distance);
}