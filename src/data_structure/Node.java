package data_structure;

/**
 * Created by William on 2018/6/3.
 */
public class Node<E> {

    /**
     * 节点的引用，指向下一个节点
     */
    public Node next;

    /**
     * 节点的对象，即内容
     */
    public E data;

    public Node(E data) {
        this.data = data;
    }

}
