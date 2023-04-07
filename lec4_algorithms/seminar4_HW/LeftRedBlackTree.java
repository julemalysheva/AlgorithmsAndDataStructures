package lec4_algorithms.seminar4_HW;

// тестовые пробные варианты

//public class LeftRedBlackTree<T extends Comparable<T>> {
//    private Node<T> root;
//
//    public LeftRedBlackTree() {
//        root = null;
//    }
//
//    public void add(T value) {
//        root = add(root, value);
//        root.setColor(NodeColor.BLACK); // set the root to black
//    }
//
//    private Node<T> add(Node<T> node, T value) {
//        if (node == null) {
//            return new Node<>(value, null, null, NodeColor.RED); // new node is always red
//        }
//
//        if (value.compareTo(node.getValue()) < 0) {
//            node.setLeft(add(node.getLeft(), value));
//        } else if (value.compareTo(node.getValue()) > 0) {
//            node.setRight(add(node.getRight(), value));
//        } else {
//            // value already exists, do nothing
//            return node;
//        }
//
//        // balance the tree
//        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
//            node = rotateLeft(node);
//        }
//
//        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
//            node = rotateRight(node);
//        }
//
//        if (isRed(node.getLeft()) && isRed(node.getRight())) {
//            flipColors(node);
//        }
//
//        return node;
//    }
//
//    private boolean isRed(Node<T> node) {
//        return node != null && node.getColor() == NodeColor.RED;
//    }
//
//    private Node<T> rotateLeft(Node<T> node) {
//        Node<T> newRoot = node.getRight();
//        node.setRight(newRoot.getLeft());
//        newRoot.setLeft(node);
//        newRoot.setColor(node.getColor());
//        node.setColor(NodeColor.RED);
//        return newRoot;
//    }
//
//    private Node<T> rotateRight(Node<T> node) {
//        Node<T> newRoot = node.getLeft();
//        node.setLeft(newRoot.getRight());
//        newRoot.setRight(node);
//        newRoot.setColor(node.getColor());
//        node.setColor(NodeColor.RED);
//        return newRoot;
//    }
//
//    private void flipColors(Node<T> node) {
//        node.setColor(NodeColor.RED);
//        node.getLeft().setColor(NodeColor.BLACK);
//        node.getRight().setColor(NodeColor.BLACK);
//    }
//
//    public void printTree() {
//        printTree(root, 0);
//    }
//
//    private void printTree(Node<T> node, int indent) {
//        if (node == null) {
//            return;
//        }
//
//        for (int i = 0; i < indent; i++) {
//            System.out.print(" ");
//        }
//
//        System.out.print(node.getValue() + " (" + node.getColor() + ")");
//        System.out.println();
//
//        printTree(node.getLeft(), indent + 2);
//        printTree(node.getRight(), indent + 2);
//    }
//
//    public boolean contains(T value) {
//        return contains(root, value);
//    }
//
//    private boolean contains(Node<T> node, T value) {
//        if (node == null) {
//            return false;
//        }
//
//        if (value.compareTo(node.getValue()) == 0) {
//            return true;
//        } else if (value.compareTo(node.getValue()) < 0) {
//            return contains(node.getLeft(), value);
//        } else {
//            return contains(node.getRight(), value);
//        }
//    }
//
//    enum NodeColor {
//        RED, BLACK
//    }
//
//    class Node<T extends Comparable<T>> {
//        private T value;
//        private Node<T> left;
//        private Node<T> right;
//        private NodeColor color;
//
//        public Node(T value, Node<T> left, Node<T> right, NodeColor color) {
//            this.value = value;
//            this.left = left;
//            this.right = right;
//            this.color = color;
//        }
//
//        public T getValue() {
//            return value;
//        }
//
//        public void setValue(T value) {
//            this.value = value;
//        }
//
//        public Node<T> getLeft() {
//            return left;
//        }
//
//        public void setLeft(Node<T> left) {
//            this.left = left;
//        }
//
//        public Node<T> getRight() {
//            return right;
//        }
//
//        public void setRight(Node<T> right) {
//            this.right = right;
//        }
//
//        public NodeColor getColor() {
//            return color;
//        }
//
//        public void setColor(NodeColor color) {
//            this.color = color;
//        }
//    }
//
//}




//!!!проверить эту реализацию с кодом по лекции, если выше класс не сработает
//public class LeftRedBlackTree<T extends Comparable<T>> {
//
//    private Node<T> root;
//
//    private enum Color {
//        RED, BLACK
//    }
//
//    private class Node<T> {
//        private T value;
//        private Node<T> left;
//        private Node<T> right;
//        private Color color;
//
//        Node(T value, Color color) {
//            this.value = value;
//            this.color = color;
//        }
//    }
//
//    public void add(T value) {
//        root = add(root, value);
//        root.color = Color.BLACK;
//    }
//
//    private Node<T> add(Node<T> node, T value) {
//        if (node == null) {
//            return new Node<>(value, Color.RED);
//        }
//
//        if (value.compareTo(node.value) < 0) {
//            node.left = add(node.left, value);
//        } else if (value.compareTo(node.value) > 0) {
//            node.right = add(node.right, value);
//        } else {
//            return node;
//        }
//
//        if (isRed(node.right) && !isRed(node.left)) {
//            node = rotateLeft(node);
//        }
//        if (isRed(node.left) && isRed(node.left.left)) {
//            node = rotateRight(node);
//        }
//        if (isRed(node.left) && isRed(node.right)) {
//            flipColors(node);
//        }
//
//        return node;
//    }
//
//    private boolean isRed(Node<T> node) {
//        return node != null && node.color == Color.RED;
//    }
//
//    private Node<T> rotateLeft(Node<T> node) {
//        Node<T> x = node.right;
//        node.right = x.left;
//        x.left = node;
//        x.color = node.color;
//        node.color = Color.RED;
//        return x;
//    }
//
//    private Node<T> rotateRight(Node<T> node) {
//        Node<T> x = node.left;
//        node.left = x.right;
//        x.right = node;
//        x.color = node.color;
//        node.color = Color.RED;
//        return x;
//    }
//
//    private void flipColors(Node<T> node) {
//        node.color = Color.RED;
//        node.left.color = Color.BLACK;
//        node.right.color = Color.BLACK;
//    }
//
//    public void printTree() {
//        printNode(root, 0);
//    }
//
//    private void printNode(Node<T> node, int level) {
//        if (node == null) {
//            return;
//        }
//
//        printNode(node.right, level + 1);
//        for (int i = 0; i < level; i++) {
//            System.out.print("   ");
//        }
//        System.out.println(node.value + " (" + node.color + ")");
//        printNode(node.left, level + 1);
//    }
//
//}

