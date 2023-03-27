package lec1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Algorithm_demo1 {

    public static void main(String[] args) {
//        List<Integer> availableDivider = findSimpleNumbers(100);
//        for (Integer integer:availableDivider) {
//            System.out.println(integer);}
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(5,counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

    }

    public static List<Integer> findAvailableDivider(int number){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) { //линейная зависимость
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findSimpleNumbers(int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            //поиск простых чисел - вложенный цикл столько, сколько операций - квадратичная зависимость
            //класс.квадратичн.ф-ция - парабола
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        return result;
    }

    public static int fib(int position, AtomicInteger counter){
        counter.incrementAndGet();
        //экспоненциальный рост алгоритма
        if(position==1 || position==2){
            return 1;
        }
        return fib(position-1, counter) + fib(position-2, counter);
    }

}
