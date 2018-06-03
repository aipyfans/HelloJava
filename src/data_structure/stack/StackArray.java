package data_structure.stack;

/**
 * Created by William on 2018/6/3.
 */
public class StackArray<E> {

    /**
     * 作为栈本质的数组
     */
    private Object[] stack;

    /**
     * 栈顶指针
     */
    private int pointer = 0;

    private int size;


    public StackArray() {
        this.size = 10;
        this.stack = new Object[10];
    }


    public StackArray(int size) {
        this.size = size;
        this.stack = new Object[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (isEmpty())
            return null;
        return (E) stack[size - 1];// 如果有元素就返回最后一个
    }

    /**
     * 移除栈顶部元素移除
     *
     * @return
     */
    public E pop() {
        E e = peek();// 保存最后一个元素的备份
        stack[size - 1] = null;// 给数组最后一个元素赋null
        size--;
        return e;
    }

    /**
     * 把项压入栈顶部
     *
     * @param item
     * @return
     */
    public E push(E item) {
        ensureCapacity(size + 1);
        stack[size++] = item;
        return item;
    }

    /**
     * 检查容量是否足够，不够再原有的数组基础创建新的数组
     *
     * @param size
     */
    public void ensureCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            // 如果栈满，则创建空间为当前栈空间两倍的栈
            Object[] temp = stack;
            stack = new Object[2 * stack.length];
            System.arraycopy(temp, 0, stack, 0, temp.length);
        }
    }

    /**
     * 返回对象在堆栈中的位置，以1 为基数
     *
     * @param o
     * @return
     */
    public int search(Object o) {
        int index = lastIndexOf(o);
        return index == -1 ? index : size - index;
    }

    /**
     * 查找下标的方法
     *
     * @param o
     * @return
     */
    private int lastIndexOf(Object o) {
        if (isEmpty()) {
            throw new EmptyStackException(); // 如果数组为空，就抛出一个自定义异常
        }
        // 当传进来的元素为空时
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (stack[i] == null) {
                    return i;
                }
            }
            // 不为空时
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(stack[i])) {
                    return i;
                }
            }
        }
        return -1; // 没有找到，返回-1
    }

    // 自定义异常
    private static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {
            super("堆栈为空");
        }
    }

}
