package lec3_linkedList_algorithms;

public class LinkedList2 {

    private Node head;
    private Node tail;

    public void printAll(){
        Node node = head;
        while (node != null){
            System.out.print(node.value + "->");
            node = node.nextNode;
        }
        System.out.println(" null");
    }


    public void addFirst(int value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.nextNode = head;
            head.previousNode = node;
        } else {
           tail = node;
        }
        head = node;
    }

    public void addLast(int value){
        Node node = new Node();
        node.value = value;
        if (tail == null) {
            head = node;//?
        } else {
            node.previousNode = tail;
            tail.nextNode = node;
        }
        tail = node;
    }

    public void removeFirst(){
        if (head != null && head.nextNode != null) {
            head.nextNode.previousNode = null;
            head = head.nextNode;
        } else {
            head = null;
            tail = null;
        }
    }

    public void removeLast(){
        if (tail != null && tail.previousNode != null) {
            tail.previousNode.nextNode = null;
            tail = tail.previousNode;
        } else {
            head = null;
            tail = null;
        }
    }

//внутр.вспомог.метод замены ссылок
    /*используется метод swap(), который меняет местами два элемента связанного списка и корректирует ссылки
    на соседние элементы. Он может быть использован как вспомогательный метод и для сортировки выбором,
    и для пузырьковой сортировки.*/
    private void swap(Node node1, Node node2){
        if (node1 != null && node2 != null){
            Node temp = node1.previousNode;
            node1.previousNode = node2.previousNode;
            node2.previousNode = temp;
            temp = node1.nextNode;
            node1.nextNode = node2.nextNode;
            node2.nextNode = temp;

            //корректируем ссылки соседних эл-тов после обмена
            if (node2.previousNode != null){
                node2.previousNode.nextNode = node2;
            }
            if (node2.nextNode != null) {
                node2.nextNode.previousNode = node2;
            }
            if (node1.previousNode != null){
                node1.previousNode.nextNode = node1;
            }
            if (node1.nextNode != null) {
                node1.nextNode.previousNode = node1;
            }
        }

    }

    /*Этот код реализует пузырьковую сортировку, где элементы связанного списка сравниваются попарно и
    обмениваются местами, если они находятся в неправильном порядке. В этой реализации используется флаг swapped,
    который показывает, были ли произведены обмены в прошлом цикле. Если обменов не было, то список уже отсортирован
    и сортировка заканчивается.*/
//    public void bubbleSort() {
//        boolean isSort = true;
//        while (isSort) {
//            isSort = false;
//            Node node = head;
//            while (node.nextNode != null) {
//                if (node.value > node.nextNode.value) {
//                    swap(node, node.nextNode);
//                    isSort = true;
//                }
//                node = node.nextNode;
//            }
//        }
//    }

//    public void bubbleSort() {
//        boolean isSort = false;
//        do {
//            Node node = head;
//
//            System.out.println(node.value);
//            while (node!= null && node.nextNode != null){
//                if (node.value > node.nextNode.value){
//                    Node before = node.previousNode;
//                    Node after = node.nextNode.nextNode;
//                    Node current = node;
//                    Node next = node.nextNode;
//
//                    current.nextNode = after;
//                    current.previousNode = next;
//                    next.nextNode = current;
//                    next.previousNode = before;
//                    if (before != null){
//                        before.nextNode = next;
//                    } else {
//                        head = next;
//                    }
//                    if (after != null){
//                        after.previousNode = current;
//                    } else {
//                        tail = current;
//                    }
//                    isSort = true;
//                }
//                node = node.nextNode;
//            }
//        } while (isSort);
//    }

    //метод Семена
    public void sort() {
        boolean needSort;
        do {
            needSort = false;
            Node node = head;
            while (node != null && node.nextNode != null){
                if (node.value > node.nextNode.value){
                    Node before = node.previousNode;
                    Node after = node.nextNode.nextNode;
                    Node current = node;
                    Node next = node.nextNode;

                    current.nextNode = after;
                    current.previousNode = next;
                    next.nextNode = current;
                    next.previousNode = before;
                    if (before != null){
                        before.nextNode = next;
                    } else {
                        head = next;
                    }
                    if (after != null) {
                        after.previousNode = current;
                    } else  {
                        tail = current;
                    }

                    needSort = true;
                }
                node = node.nextNode;
            }
        } while (needSort);
    }


    private class Node{
        private int value;
        private Node nextNode;
        private Node previousNode;

    }
}
