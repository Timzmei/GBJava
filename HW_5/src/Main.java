import java.text.CollationKey;
import java.text.Collator;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Задача 1
        Contacts contacts = new Contacts();
        contacts.setName("Timur");
        contacts.addPhoneNumber("Timur", "+79168779052");
        contacts.addPhoneNumber("Timur", "+79586254781");

        contacts.setName("Olga");
        contacts.addPhoneNumber("Olga", "+79375896540");
        contacts.addPhoneNumber("Olga", "+79112568478");

        System.out.println(contacts);

        contacts.deleteName("Olga");
        contacts.deleteName("Alexey");

        System.out.println(contacts);


        // Задача 2
        String[] array = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        List<String> list = Arrays.asList(array);

        HashMap<String, Integer> fullMap = getFullMap(list); //Подсчитали количество совпадений имен
        TreeMap<String, Integer> map = getMap(fullMap); //Оставляем только повторяющиеся имена

        System.out.println(entriesSortedByValues(map)); //Отсортировываем по убыванию популярности


    }

    private static TreeMap<String, Integer> getMap(HashMap<String, Integer> fullMap) {
        TreeMap<String, Integer> map = new TreeMap<>();
        fullMap.forEach((k,v) -> {
            if (v > 1) {
                map.put(k, v);
            }
        });

        return map;
    }

    private static HashMap<String, Integer> getFullMap(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String n: list) {
            String[] name = n.split(" ");
            if(map.containsKey(name[0])) {
                int count = map.get(name[0]);
                map.replace(name[0], count + 1);
            } else {
                map.put(name[0], 1);
            }
        }
        return map;
    }

    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e2.getValue().compareTo(e1.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}