package data_structure.queue;

/**
 * Created by William on 2018/6/3.
 */
public class QueueArray {

    /**
     * 作为队列本质的数组
     */
    private Object[] queues;

    /**
     * 队列的大小
     */
    private final int queueSize;

    /**
     * 标识数据存储位置的索引
     */
    private int setIndex = 0;

    /**
     * 标识数据读取位置的索引
     */
    private int getIndex = 0;

    public QueueArray(int size) {
        this.queueSize = size;
    }


    /**
     * 存储数据的函数
     */
    public void enquene(Object element) {
        this.queues[setIndex] = element;
        setIndex++;
        if (setIndex > queueSize) {
            setIndex = 0;
        }
    }

    /**
     * 读取数据的函数
     */
    public Object dequene() {
        Object element = this.queues[getIndex];
        getIndex++;
        if (getIndex >= queueSize) {
            getIndex = 0;
        }
        return element;
    }
}
