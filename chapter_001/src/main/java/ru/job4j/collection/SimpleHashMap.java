package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.hash;

public class SimpleHashMap<K, V> implements Iterable <User> {

    /**
     * Ассоциативный массив, является хранилищем ссылок на списки(цепочки) значений.
     * Коэффициент загрузки при расширении массива.
     * Размер хранилища.
     * Предельное количество элементов, при достижении которого,
     * размер хэш-таблицы увеличивается вдвое.
     * Поле размера массива.
     * Поле для подсчета количества элементов в коллекции.
     */
    private Entry<K, V>[] table;
    private static final float LOAD_FACTOR = 0.75f;
    private static final float CAPACITY = 16;
    private int threshold;
    private int size;
    private int modCount;

    /**
     * Конструктор, инициализирующий контейнер SimpleHashMap
     * c первоначальными размерами и учитывающий предельную загрузку.
     *
     * @param table ассоциативный массив на 16 ячеек.
     */
    public SimpleHashMap(Entry<K, V>[] table) {
        this.table = new Entry[ (int) CAPACITY ];
        this.threshold = (int) (CAPACITY * LOAD_FACTOR);
        this.size = 0;
        this.modCount = 0;
    }

    public SimpleHashMap() {
    }

    /**
     * Метод определения рамера контейнера.
     * @return размер.
     */
    public int size() {
        return this.size;
    }

    /**
     * Метод добавления элементов.
     * Проверяем, если размер массива превышает предельное количество элеентов, то
     * вызываем метод расширения контейнера resize().
     * Проверив, что ключ не null, вычисляем на основе ключа хэш, проверяем на равентсво null,
     * хешей и значений, если не null, возвращаем false, иначе добавляем
     * если совпадений нет, добавляем новый элемент.
     * если элемент с ключом null, то его значение перезаписываем.
     * @param key ключ
     * @param value значение
     * @return если значение добавлено true
     */
     public boolean insert(K key, V value) {
         if (size >= threshold) {
             resize();
         }
         if (key == null) {
             return false;
         }
        int hash = key.hashCode() ^ (key.hashCode() >>> 16) & (table.length - 1);
        if (table[hash] != null) {
            return false;
        }
        if (table[hash] == null) {
            size++;
        }
            this.table[hash] = new Entry<>(key, value, hash);
            this.modCount++;
            return true;
        }

    /**
     * Метод расширения контейнера.
     * Проверяем, если размер массива, деленный на размер хранилища превышает предельное количество элементов,
     * то сохраняем ссылку на старую таблицу, в массив записываем ссылку на новую таблицу, увеличивая размер вдвое,
     * затем присваиваем ее новой таблице, обходим старую таблицу. Проверяем, что она содердит не null Entry элемементов,
     * получаем хэш для новой таблицы(ключ и значение), и по этому хэшу помещаем новую Entry в новую таблицу.
     */
     private  void resize() {
         if (size / CAPACITY  > LOAD_FACTOR) {
             Entry<K, V>[] oldTable = this.table;
             table = new Entry[ oldTable.length * 2 ];
             Entry<K, V>[] newTab = new Entry[ oldTable.length * 2 ];
             this.table = newTab;
             for (int i = 0; i < oldTable.length; i++) {
                 Entry<K, V> el = oldTable[ i ];
                 if (el != null) {
                     int hash = hash(table[ i ].key);
                     newTab[el.hash] = new Entry<>(table[ i ].key, table[ i ].value, hash);
                 }
             }
             table = newTab;
         }
     }

    /**
     * Метод получение значений по ключу.
      * @param key ключ
     * @return полученное значение
     */
      public V get(K key) {
               V value = null;
               int hash = key.hashCode() ^ (key.hashCode() >>> 16) & (table.length - 1);
               Entry<K, V> el = this.table[hash];
                if (table[hash] == null || hash == table[hash].hashCode() && key.equals(table[hash])) {
                    return null;
                }
                return table[hash].value;
            }

    /**
     * Метод удаления объекта из контейнера.
     * Присваиваем контейенеру ссылку на массив, вычисляем хэш и ячейку в массиве по ключу.
     * Затем проверяем, что элемент существует, сравниваем ключи и хэши,
     * и возвращаем false, если объекта нет или если есть, то присваиваем ссылку на элемент за удаляемым,
     * уменьшаем размер и итерируем поле для подсчета количества элементов в коллекции.
     * @param key ключ
     * @return true, если объект удален
     */
       public boolean delete(K key) {
           if (key == null) {
               return false;
           }
           Entry<K, V>[] el = this.table;
           int hash = key.hashCode() ^ (key.hashCode() >>> 16) & (table.length - 1);
            if (table[hash] == null) {
                if (table[hash].hashCode() == key.hashCode() && key.equals(table[hash].key)) {
                       return false;
                   }
                }
                V value = table[hash].value;
                modCount++;
                size--;
                return true;
            }

            /**
             * Returns an iterator over elements of type {@code T}.
             *
             * @return an Iterator.
             */
            @Override
            public Iterator<User> iterator() {
                return new Iterator<>() {

                    /**
                     * Указатель для перебора элементов в контейненре.
                     */
                    private int cursor;

                    /**
                     * Значение счетчика на момент создания.
                     */
                    private int expectedModCount = modCount;

                    @Override
                    public boolean hasNext() {
                        if (expectedModCount != modCount) {
                            throw new ConcurrentModificationException();
                        }
                       for (int i = cursor; i < table.length; i++) {
                           if (table[i] != null) {
                               cursor = i;
                           }
                       }
                        return false;
                    }

                    @Override
                    public Entry next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return table[cursor++];
                    }
             };
      }

    public static class Entry<K, V> extends User {
        private final K key;
        private final V value;
        private final int hash;

        public Entry(K key, V value, int hash) {
            super();
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}


