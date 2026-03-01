public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петров", "89001112233");
        phoneBook.add("Петров", "89004445566");
        phoneBook.add("Иванов", "89003334455");
        phoneBook.add("Соколов", "89003334455");

        System.out.println(phoneBook.get("Петров"));
    }
}