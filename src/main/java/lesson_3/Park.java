package lesson_3;

public class Park {
    class Attraction {
        private String name;
        private String workingTime;
        private int price;

        Attraction(String name, String workingTime, int price) {
            this.name = name;
            this.workingTime = workingTime;
            this.price = price;
        }

        public void info() {
            System.out.println(name + " " + workingTime + " " + price);
        }
    }
}