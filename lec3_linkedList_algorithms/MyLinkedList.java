//package lec3_linkedList_algorithms;
//
////import java.util.LinkedList;
//
//public class MyLinkedList {
//
//    class Node{
//        private int value;
//        private Node nextNode;
//        private Node previousNode;
//    }
//    private Node head;
//    private Node tail;
//
//    //Стек
//    //добавляем элемент в начало
//    public void push(int value){
//        Node node = new Node();
//        node.value = value;
//        node.nextNode = head;
//        head = node;
//    }
//    //забираем элемент с начала
//    public Integer pull(){
//        if (head == null){
//            return null;//если int, то исключение
//        }
//        Integer result = head.value;
//        head = head.nextNode;
//        return result;
//    }
//
//    //Очередь
//    //добавляем в начало
//    public void push(int value){
//        Node node = new Node();
//        node.value = value;
//        node.nextNode = head;
//        head.previousNode = node;
//        head = node;
//    }
//    //забираем с конца
//    public Integer pull(){
//        if (tail == null){
//            return null;
//        }
//        Integer result = tail.value;
//        tail = tail.previousNode;
//        tail.nextNode = null;
//        return result;
//    }
//
//    //Поиск элементов в связном списке - O(n)
//    public Node findNode(int value){
//        Node node = head;
//        while (node.nextNode != null){
//            node = node.nextNode;
//            if (node.value == value){
//                return node;
//            }
//        }
//        return null;
//    }
//
//    //мы также можем найти элемент нужного индекса. Базовый алгоритм поиска
//    //будет выглядеть следующим образом:
//    public Node findNodeForIndex(int index){
//        Node node = head;
//        for (int i = 0; i < index; i++) {
//            node = node.nextNode;
//            if (node == null){
//                return null;
//            }
//        }
//        return node;
//    }
//
//    //Операции добавления и удаления элементов
//    public void addLast(int value){ //Как и в случае с массивом – сложность операции O(1).
//        Node node = new Node();
//        node.value = value;
//        tail.nextNode = node;//ссылка
//        node.previousNode = tail;//ссылка
//        tail = node;//сам node
//    }
//
//    public void add(int value, Node previousNode){
//        Node node = new Node();
//        node.value = value;
//        Node nextNode = previousNode.nextNode;//запомнили
//        previousNode.nextNode = node;//заменили созданной
//        node.previousNode = previousNode;//обновили ссылки
//        node.nextNode = nextNode;//обновили ссылки
//        nextNode.previousNode = node;//обновили ссылки
//    }
//
//    //O(n2)
//    //Сортировка связного списка -
//    public void sort(){
//        //сортировка выбором
//        Node node = head;
//        while (node.nextNode != null){
//            Node minPositionNode = node;
//            Node innerNode = node.nextNode;
//            while (innerNode != null){
//                if (innerNode.value < minPositionNode.value){
//                    minPositionNode = innerNode;
//                }
//                innerNode = innerNode.nextNode;
//            }
//            if (minPositionNode != node){
//                swap(node, minPositionNode);
//                //обновляем ссылки на head и tail при необходимости
//                if (minPositionNode.previousNode == null){
//                    head = minPositionNode;
//                }
//                if (node.nextNode == null){
//                    tail = node;
//                }
//
//                //сдвигаем
//                node = minPositionNode.nextNode;
//            } else {
//                node = node.nextNode;//идем к след.узлу
//            }
//        }
//    }
//
//    //внутр.вспомог.метод замены ссылок
//    /*используется метод swap(), который меняет местами два элемента связанного списка и корректирует ссылки
//    на соседние элементы. Он может быть использован как вспомогательный метод и для сортировки выбором,
//    и для пузырьковой сортировки.*/
//    private void swap(Node node1, Node node2){
//        Node temp = node1.previousNode;
//        node1.previousNode = node2.previousNode;
//        node2.previousNode = temp;
//        temp = node1.nextNode;
//        node1.nextNode = node2.nextNode;
//        node2.nextNode = temp;
//
//        //корректируем ссылки соседних эл-тов после обмена
//        if (node2.previousNode != null){
//            node2.previousNode.nextNode = node2;
//        }
//        if (node2.nextNode != null) {
//            node2.nextNode.previousNode = node2;
//        }
//        if (node1.previousNode != null){
//            node1.previousNode.nextNode = node1;
//        }
//        if (node1.nextNode != null) {
//            node1.nextNode.previousNode = node1;
//        }
//
//    }
//
//    /*Этот код реализует пузырьковую сортировку, где элементы связанного списка сравниваются попарно и
//    обмениваются местами, если они находятся в неправильном порядке. В этой реализации используется флаг swapped,
//    который показывает, были ли произведены обмены в прошлом цикле. Если обменов не было, то список уже отсортирован
//    и сортировка заканчивается.*/
//    public void bubbleSort() {
//        boolean swapped = true;
//        while (swapped) {
//            swapped = false;
//            Node node = head;
//            while (node.nextNode != null) {
//                if (node.value > node.nextNode.value) {
//                    swap(node, node.nextNode);
//                    swapped = true;
//                }
//                node = node.nextNode;
//            }
//        }
//    }
//
//
//    //Разворот связного списка
//    public void revert(){
//        Node node = head;
//
//        //меняем местами указатели на head и tail
//        Node temp = head;
//        head = tail;
//        tail = temp;
//
//        //перебираем список, переворачивая указатели
//        while (node.nextNode != null){
//            temp = node.nextNode;
//            node.nextNode = node.previousNode;
//            node.previousNode = temp;
//            node = node.previousNode;
//        }
//    }
//
//
//
//}
