package task_1;

public class Dog extends Animal {
    public static int countDog;

    public Dog(String name) {
        super(name);
        countDog++;
    }

    public String swim(int distance) {
        if (distance <= 10) {
            return getName() + " проплыл: " + distance + " м\n";
        }

        return getName() + " Не может проплыть: " + distance + " м\n";
    }

    public String run(int distance) {
        if (distance <= 500) {
            return getName() + " пробежал: " + distance + " м\n";
        }

        return getName() + " Не может пробежать: " + distance + " м\n";
    }
}