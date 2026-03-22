package lesson_4.task_1;

public class Cat extends Animal {
    public static int countCat;
    private boolean isHungry;

    public Cat(String name) {
        super(name);
        this.isHungry = true;
        countCat++;
    }

    public boolean isHungry() { 
        return isHungry;
    }

    public void eatFood(Bowl bowl, int amount) {
        int food = bowl.getFood();

        if (food < amount) {
            this.isHungry = true;
        } else {
            this.isHungry = false;
            bowl.decreaseFood(amount);
        }
    }

    public String swim(int distance) {
        return getName() + " не умеет плавать :(";
    }

    public String run(int distance) {
        if (distance <= 200) {
            return getName() + " пробежал: " + distance + " м\n";
        }

        return getName() + " не может пробежать: " + distance + " м\n";
    }
}