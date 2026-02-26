public class Bowl {
    private int food;

    Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return this.food;
    }

    public void decreaseFood(int amount) {
        this.food -= amount;
    }

    public void addFood(int food) {
        this.food += food;
    }
}