package lec4_algorithms;
//Семинар 4 - Бинарное дерево, левый ребенок меньше родителя, правый больше родителя
public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public boolean add(T value){
        Node<T> current = new Node<T>();
        current.value = value;
        if (root != null){
            Node<T> node = root;
            while (node != null){
                if (node.value.compareTo(value) > 0){
                    node.left = current;
                    return true;
                } else {
                    node.right = current;
                    return true;
                }
            }
        } else {
//            Node<T> current = new Node<T>();
//            current.value = value;
            root = current;
            return true;
        }
        return false;
    }

    public boolean find(T value){
        Node<T> node = root;
        while (node != null){
            if (node.value.equals(value)){
                return true;
            }
            if (node.value.compareTo(value) > 0){
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    private class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;
    }
}
