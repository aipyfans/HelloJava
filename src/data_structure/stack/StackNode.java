package data_structure.stack;

import data_structure.Node;

/**
 * Created by William on 2018/6/3.
 */
public class StackNode<E> {

    private Node<E> top;


    public boolean isEmpty(){
        return  top == null;
    }


    public void push(E e){
        Node<E> newNode = new Node<E>(e);
        newNode.next = top;
        top = newNode;
    }


    public E pop(){
        if(isEmpty()){
            return null;
        }
        E data = top.data;
        top = top.next;
        return data;
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }
        return top.data;
    }

}
