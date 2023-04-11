import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Contacts {
    private HashMap<String, LinkedList<String>> contacts;


    public Contacts() {
        this.contacts = new HashMap<>();
    }


    public void addPhoneNumber(String name, String phoneNumber) {
        LinkedList<String> phoneBook = getPhoneBook(name);
        phoneBook.add(phoneNumber);
        contacts.put(name, phoneBook);
    }

    public String setName(String name) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, new LinkedList<>());
            return "Новый контакт создан";
        } else {
            return "Контакт с таким именем уже существует";
        }
    }

    public String setName(String name, LinkedList<String> list) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, list);
            return "Новый контакт создан";
        } else {
            return "Контакт с таким именем уже существует";
        }
    }

    public void deleteName(String name) {
        if(contacts.containsKey(name)) {
            contacts.remove(name);
        }
    }

    public LinkedList<String> getPhoneBook(String name) {
        return contacts.get(name);
    }

    public Set<String> getContacts () {
        return  contacts.keySet();
    }

    @Override
    public String toString() {
        String result = "Contacts:\n";
        for (Map.Entry<String, LinkedList<String>> entry: contacts.entrySet()) {
            result += "\t" + entry.getKey() + " : " + entry.getValue() + "\n";
        }
        return result;
    }
}
