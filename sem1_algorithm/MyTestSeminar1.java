package sem1_algorithm;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MyTestSeminar1 {
    public static void main(String[] args) {
        System.out.println(AmountNumber(9));
        findSimpleNumbersBool(20);
        System.out.println(numberOptions(6));

        long startTime = System.nanoTime();
        int fibRes = fib1(15);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Fib Res: "+fibRes + " время выполнения: " + duration);

        startTime = System.nanoTime();
        int fibRes2 = fib2(15);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Фибоначчи линейно: " + fibRes2 + " время выполнения: " + duration);
    }

    //Задание 1
    //Необходимо написать алгоритм, считающий сумму всех чисел
    //от 1 до N.
    public static int AmountNumber(int number){
        int amount = 0;
        for (int i = 1; i <= number; i++) {
            amount += i;
        }

        return amount;
    }

    //Задание 2
    //Написать алгоритм поиска простых чисел (делятся только на себя и
    //на 1) в диапазоне от 1 до N.
    public static List<Integer> findSimpleNumbers(int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
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

    //другой вариант поиска простых чисел - кратные чисел заполняются true, что осталось false - простые
    public static void findSimpleNumbersBool(int max){
        boolean[] arr = new boolean[max];
        for (int i = 2; i*i < arr.length; i++) {
            if(!arr[i]){
                for (int j = i*i; j < arr.length; j+=i) {
                    arr[j] = true;
                }
            }
        }
        // выводим простые числа в консоль
        System.out.println();
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    //Задание 3
    //1. Необходимо написать алгоритм поиска всех доступных комбинаций
    //(посчитать количество) для количества кубиков K с количеством граней N.
    //2. У вас есть 2 варианта на выбор – количество кубиков может быть строго
    //ограничено (4 кубика, например), либо их количество будет
    //динамическим. -- просто возвести N в степень K
    public static int numberOptions(int side){ // сложность O(n^4), т.е. side^4
        int count = 0;
        for (int i = 1; i <= side ; i++) {
            for (int j = 1; j <= side ; j++) {
                for (int k = 1; k <= side ; k++) {
                    for (int l = 1; l <= side ; l++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //Задание 4 рекурсивно
    //1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
    public static int fib1(int pos){
        if (pos == 1 || pos == 2){
            return 1;
        }
        return fib1(pos - 1) + fib1(pos - 2);
    }

    //Задание 5 - Фибоначчи линейно
    public static int fib2(int pos){
        int last = 1;
        int prev = 1;
        for (int i = 2; i < pos; i++) {
            int result = last + prev;
            last = prev;
            prev = result;
        }
        return prev;
    }

}
