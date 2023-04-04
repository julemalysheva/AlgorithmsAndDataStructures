package lec3_linkedList_algorithms;

public class LinkedListHW3 {

    private Node head;
    private Node tail;

    public LinkedListHW3() {
        this.head = null;
        this.tail = null;
    }

//метод add, который будет добавлять новый узел в конец списка
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    //метод вывода
    public void printAll(){
        Node node = head;
        while (node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println(" null");
    }

    // метод разворота двухсвязного связного списка - итеративно (меньше ресурсов, чем рекурсивно)
    public void reverse() {
        Node current = this.head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            this.head = temp.prev;
        }
    }


    private class Node {
        private int value;
        private Node prev;
        private Node next;

        public Node(int data) {
            this.value = data;
            this.prev = null;
            this.next = null;
        }
    }



}
