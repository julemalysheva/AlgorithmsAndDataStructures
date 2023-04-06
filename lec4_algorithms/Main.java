package lec4_algorithms;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
        integerBinaryTree.add(1);
        integerBinaryTree.add(2);
        System.out.println(integerBinaryTree.find(1));
        System.out.println(integerBinaryTree.find(5));

    }
}
