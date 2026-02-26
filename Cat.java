public class Cat extends Animal {
    public static int countCat;
    private boolean isHungry;

    Cat(String name) {
        super(name);
        this.isHungry = false;
        countCat++;
    }

    public boolean isHungry() { 
        return isHungry;
    }

    public void eatFood(Bowl bowl, int amount) {
        int food = bowl.getFood();

        if (food < amount) {
            this.isHungry = false;
        } else {
            this.isHungry = true;
            bowl.decreaseFood(amount);
        }
    }

    public String swim(int distance) {
        return name + " не умеет плавать :(";
    }

    public String run(int distance) {
        if (distance <= 200) {
            return name + " пробежал: " + distance + " м\n";
        }

        return name + " не может пробежать: " + distance + " м\n";
    }
}