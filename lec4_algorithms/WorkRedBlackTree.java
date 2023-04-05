package lec4_algorithms;

public class WorkRedBlackTree {
    public static void main(String[] args) {
        //Для добавления новых элементов в красно-черное дерево необходимо вызвать метод insert с указанием
        // значения элемента, который необходимо добавить:
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        //Для поиска элемента в дереве необходимо вызвать метод contains с указанием значения элемента, который необходимо найти:
        boolean contains = tree.contains(20);
        System.out.println(contains);
        //Для вывода дерева на экран необходимо вызвать метод printTree:
        tree.printTree();

    }
}
