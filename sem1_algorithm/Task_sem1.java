package sem1_algorithm;

import java.util.ArrayList;
import java.util.List;

public class Task_sem1 {
    public static void main(String[] args) {
        //System.out.println(AmountNumber(10));
        //System.out.println(findCountOptions(6));
        int counter = findCountForK(6, 6);
        System.out.println("Количество комбинаций: " + counter);
        //System.out.println(fib(7));
        //System.out.println(findFib(9));
        //testTime();
    }

    //Задание 1
    //Необходимо написать алгоритм, считающий сумму всех чисел
    //от 1 до N.
    //по памяти O(1)
    public static int AmountNumber(int number){
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += i;
        }
        return result;
    }

    //по памяти O(n)
    //по времени O(n2)
    public static List<Integer> findSimpleNumbers(int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) { //n
            //поиск простых чисел - вложенный цикл столько, сколько операций - квадратичная зависимость
            boolean simple = true;
            for (int j = 2; j < i; j++) { //в конечном счете n операций
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        return result;
    }

    //другой вариант поиска простых чисел - кратные чисел заполняются true, что осталось false - простые
    //O(n*log(n))
    //по памяти O(n)
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

    //Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать количество)
    // для количества кубиков K с количеством граней N.
    //4 - O(n4)
    //по памяти O(1)
    public static int findCountOptions(int numSide){
        int count = 0;
        for (int i = 1; i <= numSide ; i++) {
            for (int j = 1; j <= numSide ; j++) {
                for (int k = 1; k <= numSide ; k++) {
                    for (int l = 1; l <= numSide ; l++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int recursiveCounter(int depth, int maxDepth, int numSide){
        int count = 0;
        for (int i = 1; i <= numSide ; i++) {
            if (depth == maxDepth){
                    count++;
            } else {
                    count += recursiveCounter(depth + 1 ,maxDepth, numSide); //depth++
            }
        }
        return count;
    }

    public static int findCountForK(int numSide, int k){
        if (k <= 0) return 0;
        return recursiveCounter(1, k, numSide);

    }

    public static int fib(int pos){
        int last = 1;
        int prev = 1;
        for (int i = 2; i <= pos ; i++) {
            int res = last + prev;
            last = prev;
            prev = res;
        }
        return  prev;
    }

    public static boolean findFib(int number){
        int last = 1;
        int prev = 1;
        if (number < 2) {
            return true;
        }
        int res = last + prev;
        while (res < number){
            last = prev;
            prev = res;
            res = last + prev;
            System.out.println(res);
        }
        return res == number;
    }

    public static int fibRecursive(int position){
        //экспоненциальный рост алгоритма
        if(position==1 || position==2){
            return 1;
        }
        return fibRecursive(position-1) + fibRecursive(position-2);
    }

    public static void testTime(){
        for (int i = 10; i <= 50; i+=10) { //<=
            //Date startDate = new Date();
            long startTime = System.nanoTime();
            fib(i);
            //Date endDate = new Date();
            long endTime = System.nanoTime();
            long intervar = endTime - startTime;
                    //endDate.getTime() - startDate.getTime();
//            startDate = new Date();
            startTime = System.nanoTime();
            fibRecursive(i);
            //endDate = new Date();
            endTime = System.nanoTime();
            long recVar = endTime - startTime;
                    //endDate.getTime() - startDate.getTime();
            System.out.println("Итерация с " + i + " - recursion: " + recVar + ", linearly: " + intervar);
           //System.out.println("Итерация с " + i + " lin " + intervar);
        }
    }


}
