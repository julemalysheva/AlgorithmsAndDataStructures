package lec4_algorithms;

//Класс для бинарного дерева на Java можно описать следующим образом:
public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else if (cmp > 0) {
            node.right = insert(node.right, data);
        } else {
            // данные уже существуют в дереве
        }

        return node;
    }

    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            return contains(node.left, data);
        } else if (cmp > 0) {
            return contains(node.right, data);
        } else {
            return true;
        }
    }

    // Здесь могут быть реализованы дополнительные методы обхода (in-order, pre-order, post-order).
    //Приведем пример метода для обхода дерева в порядке in-order:
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
    //Этот метод выводит значения элементов в порядке in-order, т.е. сначала левое поддерево, затем корень,
    // и затем правое поддерево. Обходы в порядке pre-order и post-order могут быть реализованы аналогичным образом.

}
