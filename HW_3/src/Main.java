import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = genereteList();
        // Список с произвольными значениями
        System.out.println(list);
        // Список с удаленнными четными значений
        System.out.println(deleteEven(list));

        // Минимальное значение
        System.out.println(Collections.min(list));

        // Максимальной значение
        System.out.println(Collections.max(list));

        // Среднее арифмитическое значение
        System.out.println(averageOfList(list));

    }

    public static List<Integer> genereteList() {
        List<Integer> array = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            array.add(new Random().nextInt(100));
        }
        return array;
    }

    public static List<Integer> deleteEven(List<Integer> list) {
        for(int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        return list;
    }

    public static double averageOfList(List<Integer> list) {
        int sum = 0;
        for(int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
        }
        return (double) sum / list.size();
    }

}