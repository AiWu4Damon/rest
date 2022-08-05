package com.tuya.dameng.fan.queue;


/**
 *
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 *
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 */
public class MyCircularQueue {

    private Node head;

    private Node tail;

    private final Node initNode;


    public MyCircularQueue(int k) {
        if (k < 1){
            throw new IllegalArgumentException();
        }
        initNode = new Node();
        Node point = initNode;
        for (int i=1; i< k; i++){
            point = new Node(point);
        }
        initNode.next = point;
    }
    
    public boolean enQueue(int value) {
        if (head == null){
            head = initNode.next;
            tail = head;
            this.head.value = value;
            return true;
        }else if (tail.next.value == null){
            tail = tail.next;
            tail.value = value;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (head != null && head.next.value != null){
            head.value = null;
            head = head.next;
            return true;
        }else if (head != null && head.next.value == null){
            head.value = null;
            head = null;
            tail = null;
            return true;
        }
        return false;
    }
    
    public int front() {
        return head == null ? -1 : head.value;
    }
    
    public int rear() {
        return tail == null ? -1 : tail.value;
    }
    
    public boolean isEmpty() {
        return head == null || tail == null;
    }
    
    public boolean isFull() {
        return !isEmpty() && tail.next == head;
    }


    private static class Node{
        /**
         * 放置的数据
         */
        private volatile Integer value;

        private volatile Node next;

        private Node(Node next){
            this.next = next;
        }

        public Node(){
        }
    }


    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);

        myCircularQueue.deQueue();
        System.out.println(myCircularQueue.front());

        myCircularQueue.enQueue(3);
        System.out.println(myCircularQueue.front());
        System.out.println(myCircularQueue.rear());
    }
}