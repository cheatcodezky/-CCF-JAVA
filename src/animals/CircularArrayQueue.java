package animals;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by 95112 on 2018/4/3.
 */
public class CircularArrayQueue<E> implements Queue<E> {
    private E[] e = (E[]) new Object[10];
    private int head = 0,tail =0;
    @Override
    public int size() {
        return e.length;
    }

    @Override
    public boolean isEmpty() {
        if (this.head == this.tail)
            return true;
        else
            return false;
    }

    @Override
    public boolean contains(Object o) {
        boolean find = false;
        for (int i=0 ; i < e.length; i++)
            if (e[i].equals(o))
                find = true;
        if (find)
            return true;
        else
            return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
