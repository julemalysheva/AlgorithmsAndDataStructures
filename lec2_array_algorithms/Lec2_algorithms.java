package lec2_array_algorithms;

import java.util.Arrays;

public class Lec2_algorithms {
    public static void main(String[] args) {
        int[] array = new int[]{8,9,4,7,5,1,3,2,0,6};
        //bubbleSort(array);
        //selectSort(array);
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }


    //Сортировка пузырьком
    public static void bubbleSort(int[] array){
        boolean needSort;
        do {
            needSort = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    needSort = true;
                }
            }
        } while (needSort);
    }

    //Сортировка выбором
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length -1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]){
                    minPosition = j;
                }
            }
            if (minPosition != i){
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    //Сортировка вставками
    public static void insertSort(int [] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //Алгоритмы поиска
    //простой перебор

    public static int findIndex(int value, int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }

    //Бинарный поиск - рекурсивно
    public static int binarySearch(int value, int[] array, int min, int max){
        int midpoint;
        if (max < min){
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] < value){
            return binarySearch(value, array, midpoint + 1, max);
        } else {
            if (array[midpoint] > value){
                return binarySearch(value, array, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }

    /*Продвинутые алгоритмы сортировки
Быстрая сортировка (quicksort)
*/






}
