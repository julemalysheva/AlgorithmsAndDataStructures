package lec4_algorithms;
//Классическая хеш-таблица - это структура данных, которая использует хеш-функцию для преобразования ключа
// в индекс массива, где значение элемента массива представляет собой соответствующее значение.
public class HashTable<K, V> {

    private int size;
    private int capacity;
    private Entry<K, V>[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Entry[capacity];
    }

    //В данном примере реализован класс HashTable, который принимает два типа ключа K и значения V.
    // Он содержит приватные поля size, capacity и table, где size представляет количество элементов в таблице,
    // capacity определяет размер массива, используемого для хранения элементов таблицы,
    // а table - это массив объектов Entry, где каждый объект представляет собой пару ключ-значение.
    //
    //В конструкторе HashTable создается массив объектов Entry с размером capacity.

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = entry;
            size++;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = entry;
                size++;
            }
        }
    }

    //Метод put используется для добавления элемента в таблицу. Он сначала вычисляет хеш-код ключа с помощью метода hash,
    // а затем проверяет, есть ли уже элемент в массиве table по соответствующему индексу. Если элемента еще нет,
    // то новый элемент добавляется в массив table. В противном случае происходит поиск элемента в связном списке,
    // связанном с этим индексом. Если элемент найден, его значение обновляется. Если элемент не найден, новый элемент
    // добавляется в конец связного списка.
    public V get(K key) {
        int index = hash(key);

        if (table[index] == null) {
            return null;
        } else {
            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }
            return null;
        }
    }
    //Метод get используется для поиска значения по ключу. Он вычисляет хеш-код ключа с помощью метода hash и
    // ищет элемент в массиве table. Если элемент найден, метод перебирает связный список элементов, связанных с этим
    // индексом, чтобы найти нужный ключ. Если ключ найден, метод возвращает его значение. Если ключ не найден, метод возвращает null.

    public void remove(K key) {
        int index = hash(key);

        if (table[index] == null) {
            return;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        table[index] = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                    return;
                }
                previous = current;
                current = current.next;
            }
        }
    }
    //Метод remove используется для удаления элемента из таблицы по ключу. Он вычисляет хеш-код ключа с помощью метода
    // hash и ищет элемент в массиве table. Если элемент найден, метод перебирает связный список элементов, связанных
    // с этим индексом, чтобы найти нужный ключ. Если ключ найден, метод удаляет элемент из связного списка и уменьшает
    // размер таблицы на единицу.

    public boolean containsKey(K key) {
        return get(key) != null;
    }
    //Метод containsKey используется для проверки наличия ключа в таблице. Он вызывает метод get и возвращает true,
    // если значение не равно null.

    public boolean isEmpty() {
        return size == 0;
    }
    //Метод isEmpty используется для проверки, является ли таблица пустой.

    public int size() {
        return size;
    }
    //Метод size используется для получения количества элементов в таблице.

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    //Класс Entry представляет собой узел связного списка.
    // Он содержит ключ key, значение value и ссылку на следующий элемент списка next.
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    //Класс Entry используется для создания связных списков, которые используются для разрешения коллизий.
}
