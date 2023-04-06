import java.util.*;

public class Main {
    public static LinkedList<Integer> list;
    public static void main(String[] args) {
        list = genereteList();
        // Список с произвольными значениями
        System.out.println(list);
        // перевернутый список
        System.out.println(reverseList(list));

        // очередь с помощью LinkedList
        NewQueue<Integer> queue = new NewQueue<>();

        // enqueue() — помещает элемент в конец очереди
        queue.enqueue(12);
        queue.enqueue(42);
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(47);
        queue.enqueue(9);
        queue.enqueue(65);
        queue.enqueue(52);
        queue.enqueue(11);
        queue.enqueue(185);
        queue.enqueue(16);
        queue.enqueue(7);


        // dequeue() — возвращает первый элемент из очереди и удаляет его
        System.out.println("Список до\n" + queue.toString());
        System.out.println(queue.dequeue());
        System.out.println("Список после\n" + queue);


        // first() — возвращает первый элемент из очереди, не удаляя
        System.out.println("Список до\n" + queue);
        System.out.println(queue.first());
        System.out.println("Список после\n" + queue);

        // сумма всех значений
        System.out.println(sum(list));



    }

    public static LinkedList<Integer> genereteList() {
        LinkedList<Integer> array = new LinkedList<>();
        for(int i = 0; i < 20; i++) {
            array.add(new Random().nextInt(100));
        }
        return array;
    }

    public static List<Integer> reverseList(LinkedList<Integer> list) {
        List<Integer> array = list;
        Collections.reverse(array);
        return array;
    }

    public static Integer sum(LinkedList<Integer> list) {
        int sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }


}