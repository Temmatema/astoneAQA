public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean reservationStatus;

    Product(String name, String productionDate, String manufacturer, String countryOfOrigin, int price, boolean reservationStatus) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Название: " + name + "\n" +
            "Дата производства: " + productionDate + "\n" +
            "Производитель: " + manufacturer + "\n" +
            "Страна: " + countryOfOrigin + "\n" +
            "Цена: " + price + "\n" +
            "Забронирован: " + reservationStatus;
    }
}
