package lec4_algorithms.seminar4_HW;


public class RedBlackTree<T extends Comparable<T>> {
    private Node<T> root; // корень дерева

    private enum Color {
        RED,
        BLACK
    }

    // Узел дерева
    private class Node<T> {
        T value; // значение узла
        Node<T> left; // левый потомок
        Node<T> right; // правый потомок
        Color color; // цвет узла

        Node(T value, Color color) {
            this.value = value;
            this.color = color;
        }//конструктор узла
    }

    // Добавление элемента в дерево
    public void add(T value) {
        root = add(root, value); // добавление элемента
        root.color = Color.BLACK; // убеждаемся, что корень черный
    }

    // Добавление элемента в поддерево с заданным корнем
    private Node<T> add(Node<T> node, T value) {
        if (node == null) { // если узел пустой, создаем новый узел
            return new Node<>(value, Color.RED); // новый узел всегда красный
        }

        // Сравниваем значение добавляемого элемента с текущим узлом
        if (value.compareTo(node.value) < 0) { // значение меньше текущего узла, добавляем в левое поддерево
            node.left = add(node.left, value);
        } else if (value.compareTo(node.value) > 0) { // значение больше текущего узла, добавляем в правое поддерево
            node.right = add(node.right, value);
        }

        // Проверяем свойства красно-черного дерева и применяем операции поворота и перекрашивания узлов при необходимости
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    // Проверка, является ли узел красным
    private boolean isRed(Node<T> node) {
        return node != null && node.color == Color.RED;
    }

    // Левый поворот вокруг узла node
    private Node<T> rotateLeft(Node<T> node) {
        Node<T> tNode = node.right;
        node.right = tNode.left;
        tNode.left = node;
        tNode.color = node.color;
        node.color = Color.RED;
        return tNode;
    }

    // Правый поворот вокруг узла node
    private Node<T> rotateRight(Node<T> node) {
        Node<T> tNode = node.left;
        node.left = tNode.right;
        tNode.right = node;
        tNode.color = node.color;
        node.color = Color.RED;
        return tNode;
    }

    // Перекрашивание узлов
    private void flipColors(Node<T> node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    //метод для печати дерева в консоль
    public void printTree() {
        printTree(root, "", true);
    }

    //рекурсивный метод обхода узлов для вывода в консоль
    private void printTree(Node<T> node, String prefix, boolean isTail) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isTail ? "\\-- " : "|-- ") + node.value + " (" + node.color + ")");
        printTree(node.left, prefix + (isTail ? "    " : "|   "), false);
        printTree(node.right, prefix + (isTail ? "    " : "|   "), true);
    }

}


