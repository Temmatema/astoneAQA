package lesson_4.task_1;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
            new Cat("Барсик"),
            new Cat("Мурзик"),
            new Cat("Пушок")
        };

        Bowl bowl = new Bowl(50);

        cats[0].eatFood(bowl, 15);
        cats[1].eatFood(bowl, 20);
        cats[2].eatFood(bowl, 40);

        for (Cat c : cats) {
            System.out.println(c.getName() + (c.isHungry() ? " голоден." : " покушал."));
        }
    }
}