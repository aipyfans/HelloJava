package data_structure.queue;

import java.util.LinkedList;

/**
 * Created by William on 2018/6/3.
 */
public class QueueList<E> {

    private LinkedList<E> list;

    public QueueList() {
        list = new LinkedList<E>();
    }

    //入队
    public  void put(E e) {
        list.addLast(e);
    }

    //出队
    public  E pop() {
        return list.removeFirst();
    }

    public  boolean isEmpty() {
        return list.isEmpty();
    }

    public  int size() {
        return list.size();
    }

    //获得队列的第一个元素
    public  E front() {
        return list.getFirst();
    }

}
