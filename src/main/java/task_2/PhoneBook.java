package task_2;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, ArrayList<String>> phoneBook;

    PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phone) {
        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(phone);
    }

    public ArrayList<String> get(String lastName) {
        return phoneBook.get(lastName);
    }
}