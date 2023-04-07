package lec4_algorithms.seminar4_HW;

public class MainSeminar4HW {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(15);
        tree.add(1);
        tree.add(8);
        tree.add(24);

        //вывод | - левый, \ - правый

        //\-- 15 (BLACK)
        //    |-- 5 (RED)
        //    |   |-- 3 (BLACK)
        //    |   |   |-- 1 (RED)
        //    |   \-- 8 (BLACK)
        //    \-- 24 (BLACK)

        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);
        //с учетом добавленных:
        //\-- 15 (BLACK)
        //    |-- 5 (BLACK)
        //    |   |-- 3 (BLACK)
        //    |   |   |-- 1 (RED)
        //    |   \-- 10 (BLACK)
        //    |       |-- 8 (RED)
        //    \-- 40 (BLACK)
        //        |-- 24 (RED)
        //        |   |-- 20 (BLACK)
        //        |   \-- 30 (BLACK)
        //        |       |-- 25 (RED)
        //        \-- 50 (BLACK)

        tree.add(45);
        tree.add(60);
        //и еще добавим  - сохраняется глубина по черным узлам и правила LLRBTREE
        //\-- 40 (BLACK)
        //    |-- 15 (RED)
        //    |   |-- 5 (BLACK)
        //    |   |   |-- 3 (BLACK)
        //    |   |   |   |-- 1 (RED)
        //    |   |   \-- 10 (BLACK)
        //    |   |       |-- 8 (RED)
        //    |   \-- 24 (BLACK)
        //    |       |-- 20 (BLACK)
        //    |       \-- 30 (BLACK)
        //    |           |-- 25 (RED)
        //    \-- 50 (BLACK)
        //        |-- 45 (BLACK)
        //        \-- 60 (BLACK)

        tree.printTree();


    }
}
