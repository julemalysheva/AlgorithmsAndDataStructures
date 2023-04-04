package lec3_linkedList_algorithms;


public class Sem3HW {
    public static void main(String[] args) {
        LinkedListHW3 list = new LinkedListHW3();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.printAll(); //1->2->3->4->5-> null
        list.reverse();
        // Вывод списка после разворота
        list.printAll(); //5->4->3->2->1-> null

    }
}
