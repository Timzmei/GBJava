import java.util.*;

public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook(1, "Lenovo", "AMD", 15, "Linux", "black", "game", "GeForce", 500, 1000, 4);
        Notebook notebook1 = new Notebook(8, "Acer", "AMD", 15, "Windows", "black", "game", "GeForce", 1000, 0, 2);
        Notebook notebook2 = new Notebook(16, "Acer", "Intel", 15, "Linux", "silver", "game", "GeForce", 500, 1000, 4);
        Notebook notebook3 = new Notebook(16, "Asus", "Intel", 17, "Windows", "black", "game", "GeForce", 1000, 0, 4);
        Notebook notebook4 = new Notebook(8, "MSI", "Intel", 15, "Linux", "silver", "game", "GeForce", 2000, 0, 2);
        Notebook notebook5 = new Notebook(8, "Honor", "Intel", 15, "Windows", "black", "game", "GeForce", 1000, 0, 4);


        List<Notebook> list = new ArrayList<>();
        list.add(notebook);
        list.add(notebook1);
        list.add(notebook2);
        list.add(notebook3);
        list.add(notebook4);
        list.add(notebook5);

        HashSet<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook, notebook1, notebook2, notebook3, notebook4, notebook5));

        System.out.println("Выберите критерии для фильтрации ноутбуков");

        System.out.println("Здравствуйте");
        System.out.print("Введите цифру, соответствующую необходимому критерию:\n 1 - ОЗУ \n 2 - Объем ЖД \n 3 - Операционная система \n 4 - цвет \n или 5, чтобы осуществить поиск\n");
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Object> filters = new HashMap<>();
        while (n != 5) {
            if (n == 1) {
                System.out.println("Введите минимальную оперативную память");
                Integer temp = sc.nextInt();
                sc.nextLine();
                filters.put("ram", temp);
            }
            if (n == 2) {
                System.out.println("Введите минимальный объем ЖД");
                Integer temp = sc.nextInt();
                sc.nextLine();
                filters.put("hdd", temp);
            }
            if (n == 3) {
                System.out.println("Введите ОС");
                String temp = sc.nextLine();
                filters.put("os", temp);
            }
            if (n == 4) {
                System.out.println("Введите цвет");
                String temp = sc.nextLine();
                filters.put("color", temp);
            }
            System.out.print("Введите цифру, соответствующую необходимому критерию:\n 1 - ОЗУ \n 2 - Объем ЖД \n 3 - Операционная система \n 4 - цвет \n или 5, чтобы осуществить поиск\n");
            n = sc.nextInt();
            sc.nextLine();
        }
        HashSet<Notebook> res = getFilterSet(notebooks, filters);

        Iterator it = res.iterator();
        while (it.hasNext()) {
            Notebook lap = (Notebook) it.next();
            System.out.println(lap.toString());
            System.out.println();
        }


    }

    private static HashSet<Notebook> getFilterSet(HashSet<Notebook> notebooks, HashMap<String, Object> filters) {
        HashSet<Notebook> res = new HashSet<>();
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            System.out.println(entry.getKey());
            if (entry.getKey().equals("ram")) {
                notebooks = getFilterRam(notebooks, entry);

            }
            if (entry.getKey().equals("hdd")) {
//                System.out.println(res);
//                System.out.println(notebooks);
                notebooks = getFilterHdd(notebooks, entry);

            }
            if (entry.getKey().equals("os")) {
                notebooks = getFilterOs(notebooks, entry);

            }
            if (entry.getKey().equals("color")) {
                notebooks = getFilterColor(notebooks, entry);
            }
        }
        return notebooks;
    }

    private static HashSet<Notebook> getFilterColor(HashSet<Notebook> notebooks, Map.Entry<String, Object> entry) {
        HashSet<Notebook> res = new HashSet<>();
        Iterator it = notebooks.iterator();
        while (it.hasNext()) {
            Notebook lap = (Notebook) it.next();
            if (lap.getColor().equals(entry.getValue())) {
                res.add(lap);
            }
        }
        return res;
    }

    private static HashSet<Notebook> getFilterOs(HashSet<Notebook> notebooks, Map.Entry<String, Object> entry) {
        HashSet<Notebook> res = new HashSet<>();
        Iterator it = notebooks.iterator();
        while (it.hasNext()) {
            Notebook lap = (Notebook) it.next();
            if (lap.getOs().equals(entry.getValue())) {
                res.add(lap);
            }
        }
        notebooks = res;
        return notebooks;
    }

    private static HashSet<Notebook> getFilterHdd(HashSet<Notebook> notebooks, Map.Entry<String, Object> entry) {
        HashSet<Notebook> res = new HashSet<>();
        Iterator it = notebooks.iterator();
//                System.out.println(it.next());
        while (it.hasNext()) {
            Notebook lap = (Notebook) it.next();
            if (lap.getHdd() >= (Integer) entry.getValue()) {
                res.add(lap);
            }
        }
        notebooks = res;
        return notebooks;
    }

    private static HashSet<Notebook> getFilterRam(HashSet<Notebook> notebooks, Map.Entry<String, Object> entry) {
        HashSet<Notebook> res = new HashSet<>();
        Iterator it = notebooks.iterator();
        while (it.hasNext()) {
            Notebook note = (Notebook) it.next();
            if (note.getRam() >= (Integer) entry.getValue()) {
                res.add(note);
            }

        }

        notebooks = res;
        return notebooks;
    }
}