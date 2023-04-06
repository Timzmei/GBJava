import java.util.Collection;
import java.util.LinkedList;

public class NewQueue<E> extends LinkedList<E> {

    private LinkedList<E> queue;
    transient int size = 0;


    public NewQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(E el) {
        queue.add(el);
    }

    public E dequeue() {
        E el = queue.getFirst();
        queue.remove(0);
        return el;

    }

    public E first() {
        return queue.getFirst();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
