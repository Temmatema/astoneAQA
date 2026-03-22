package lesson_3;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product(
                "Samsung S25 Ultra",
                "01.02.2025",
                "Samsung Corp.",
                "Korea",
                5599,
                true
        );

        productsArray[1] = new Product(
                "iPhone 17",
                "10.03.2025",
                "Apple",
                "USA",
                6200,
                false
        );

        productsArray[2] = new Product(
                "Xiaomi 15",
                "15.01.2025",
                "Xiaomi",
                "China",
                3200,
                true
        );

        productsArray[3] = new Product(
                "Google Pixel 10",
                "20.04.2025",
                "Google",
                "USA",
                4800,
                false
        );

        productsArray[4] = new Product(
                "Sony Xperia Z7",
                "05.02.2025",
                "Sony",
                "Japan",
                4100,
                true
        );

        Park.Attraction attraction = new Park().new Attraction("Горки", "10-20", 2000);
        System.out.println(productsArray[0].toString());
        attraction.info();
    }
}