package lec4_algorithms;
//Красно-черное дерево - это сбалансированное бинарное дерево поиска, которое обеспечивает эффективную вставку,
// удаление и поиск элементов
//!!!Проверить, выдает ошибки!
public class RedBlackTree<T extends Comparable<T>> {

    private Node<T> root;

    // Класс для узла дерева
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
        Node<T> parent;
        boolean isRed;

        Node(T value, Node<T> parent) {
            this.value = value;
            this.parent = parent;
            this.isRed = true;
        }
    }

    // Конструктор класса дерева
    public RedBlackTree() {
        root = null;
    }

    // Метод для вставки нового элемента в дерево
    public void insert(T value) {
        Node<T> node = new Node<>(value, null);
        if (root == null) {
            root = node;
        } else {
            Node<T> current = root;
            Node<T> parent = null;
            while (true) {
                parent = current;
                if (value.compareTo(current.value) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        node.parent = parent;
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        node.parent = parent;
                        break;
                    }
                }
            }
            fixTree(node);
        }
    }

    // Метод для балансировки дерева после вставки элемента
    private void fixTree(Node<T> node) {
        while (node != root && node.parent.isRed) {
            if (node.parent == node.parent.parent.left) {
                Node<T> uncle = node.parent.parent.right;
                if (uncle != null && uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rotateRight(node.parent.parent);
                }
            } else {
                Node<T> uncle = node.parent.parent.left;
                if (uncle != null && uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.isRed = false;
    }

    // Метод для левого поворота узла
    private void rotateLeft(Node<T> node) {
        Node<T> rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }
    // Метод для правого поворота узла
    private void rotateRight(Node<T> node) {
        Node<T> leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    // Метод для удаления элемента из дерева
    public void delete(T value) {
        // Реализация удаления опущена для упрощения
    }

    // Метод для поиска элемента в дереве
    public boolean contains(T value) {
        Node<T> current = root;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            } else if (current.value.compareTo(value) < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return false;
    }

    // Метод для вывода дерева на экран
    public void printTree() {
        printTree(root);
    }

    // Рекурсивный метод для вывода дерева на экран
    private void printTree(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " " + (node.isRed ? "RED" : "BLACK"));
        printTree(node.left);
        printTree(node.right);
    }

}