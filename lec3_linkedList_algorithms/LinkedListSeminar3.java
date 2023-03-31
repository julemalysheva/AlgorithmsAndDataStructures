package lec3_linkedList_algorithms;

public class LinkedListSeminar3 {

    private Node head;
    //private Node tail;

    public void addFirst(int value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.nextNode = head;
        }
        head = node;
    }

    public void addLast(int value){
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.nextNode != null){
                last = last.nextNode;
            }
            last.nextNode = node;
        }
    }

    public void removeFirst(){
        if (head != null) {
            head = head.nextNode;
        }
    }

    public void removeLast(){
//        System.out.println("head " + head.value);

        if (head != null){
            Node node = head;
//            System.out.println("node.nextNode " + node.nextNode.value);

            while (node.nextNode != null){
                if (node.nextNode.nextNode == null){
                    node.nextNode = null;
                    return;
                }
                node = node.nextNode;
//                System.out.println("node " + node.value);
            }
//            node = null;
        }
    }

    public boolean findNode(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return true;
            }
            node = node.nextNode;
        }
        return false;
    }

    public void printAll(){
        Node node = head;
        while (node != null){
            System.out.print(node.value + "->");
            node = node.nextNode;
        }
        System.out.println(" null");
    }

    private class Node{
        private int value;
        private Node nextNode;

    }


}
