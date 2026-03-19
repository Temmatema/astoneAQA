package task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private final HashMap<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phone) {
        for (List<String> phones : phoneBook.values()) {
            if (phones.contains(phone)) {
                System.out.println("Номер уже существует: " + phone);
                return;
            }
        }

        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(phone);
    }

    public ArrayList<String> get(String lastName) {
        return phoneBook.get(lastName);
    }
}