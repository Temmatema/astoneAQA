public class Dog extends Animal {
    public static int countDog;

    Dog(String name) {
        super(name);
        countDog++;
    }

    public String swim(int distance) {
        if (distance <= 10) {
            return name + " проплыл: " + distance + " м\n";
        }

        return name + " Не может проплыть: " + distance + " м\n";
    }

    public String run(int distance) {
        if (distance <= 500) {
            return name + " пробежал: " + distance + " м\n";
        }

        return name + " Не может пробежать: " + distance + " м\n";
    }
}