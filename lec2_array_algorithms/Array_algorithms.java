package lec2_array_algorithms;
// это файл для моих тестов и семинара

public class Array_algorithms {
    public static void main(String[] args) {

    }

    //Напишем алгоритм сортировки выбором на Java:
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
/*В этом алгоритме мы проходим по массиву и находим наименьший элемент в оставшейся части массива.
Затем мы меняем его местами с первым неотсортированным элементом.
Таким образом, на каждом шаге мы находим наименьший неотсортированный элемент и перемещаем его на свое
место в отсортированной части массива.
Сложность сортировки выбором составляет O(n^2), так как на каждой итерации внешнего цикла мы
проходимся по всем элементам оставшейся части массива, а внутренний цикл проходит по оставшейся части массива
от i+1 до конца. Признаком квадратичной сложности является увеличение времени выполнения при увеличении размера массива
 в квадрат.*/

    /*Сложность по памяти сортировки выбором на Java составляет O(1),
    так как алгоритм сортирует массив "на месте", не используя дополнительную память для хранения элементов.
Для сортировки выбором на Java требуется константное количество дополнительной памяти,
не зависящее от размера входных данных. В этом алгоритме мы используем только несколько переменных
для хранения текущего минимального элемента и временного элемента при перестановке.*/

    //бинарный поиск
    public static int binarySearch(int[] arr, int target) {
        int left = 0; // левая граница поиска
        int right = arr.length - 1; // правая граница поиска

        while (left <= right) { // продолжаем поиск пока левая граница меньше или равна правой
            int mid = (left + right) / 2; // находим середину текущего диапазона

            if (arr[mid] == target) { // если центральный элемент совпадает с целевым значением
                return mid; // возвращаем его индекс
            } else if (arr[mid] < target) { // если центральный элемент меньше целевого значения
                left = mid + 1; // продолжаем поиск в правой половине массива
            } else { // иначе (центральный элемент больше целевого значения)
                right = mid - 1; // продолжаем поиск в левой половине массива
            }
        }

        return -1; // если целевое значение не найдено, возвращаем -1
    }
/*Этот алгоритм принимает на вход отсортированный массив arr и целевое значение target,
 и возвращает индекс элемента в массиве, равного target, или -1, если такой элемент не найден.
Алгоритм работает путем сужения диапазона поиска в два раза на каждой итерации.
На каждом шаге мы находим середину текущего диапазона, сравниваем его со значением target и
родолжаем поиск в правой или левой половине массива в зависимости от результата сравнения.*/

//вот пример алгоритма быстрой сортировки на Java:
public static void quickSort(int[] arr, int left, int right) {
    if (left < right) {
        // выбираем опорный элемент
        int pivotIndex = partition(arr, left, right);
        // рекурсивно вызываем функцию для левой части массива
        quickSort(arr, left, pivotIndex - 1);
        // рекурсивно вызываем функцию для правой части массива
        quickSort(arr, pivotIndex + 1, right);
    }
}

    public static int partition(int[] arr, int left, int right) {
        // выбираем опорный элемент
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                // меняем местами элементы
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // меняем местами опорный элемент и элемент на позиции i+1
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }
/*В этом примере функция quickSort рекурсивно вызывает себя для левой и правой части массива,
пока массив не будет полностью отсортирован. Функция partition выбирает опорный элемент и переставляет
элементы в массиве так, чтобы элементы, меньшие опорного, оказались перед ним, а элементы, большие опорного,
оказались после него. Возвращаемое значение функции partition - индекс опорного элемента после перестановки элементов.*/

//здесь по ссылке ранее написанный алгоритмя на Java heapSort
    //https://github.com/julemalysheva/Java_introduction/blob/16c087febfe3243326a255c14ce9ac2605d534e9/sem5HW/Task03_Sem5HW.java

}