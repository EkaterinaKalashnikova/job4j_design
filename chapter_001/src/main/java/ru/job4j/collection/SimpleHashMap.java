package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Entry> {

    /**
     * Ассоциативный массив, является хранилищем ссылок на списки(цепочки) значений.
     * Коэффициент загрузки при расширении массива.
     * Размер хранилища.
     * Поле размера массива.
     * Поле для подсчета количества элементов в коллекции.
     */
    private Entry<K, V>[] table;
    private static final float LOAD_FACTOR = 0.75f;
    private static final float CAPACITY = 16;
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
        this.size = 0;
        this.modCount = 0;
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
     * Вычисляем хеш на основе ключа, проверяем ключ на равентсво null,
     * хешей и значений, если совпало, возвращаем false,
     * если совпадений нет, добавляем новый элемент.
     * если элемент с ключом null, то его значение перезаписываем.
     * @param key ключ
     * @param value значение
     * @return если значение добавлено true
     */
     public boolean insert(K key, V value) {
        boolean market = false;
         int hash = key.hashCode() ^ (key.hashCode() >>> 16);
        if (table[ hash ] != null && hash == table[ hash ].hashCode()
                && key == table[hash].key && key.equals(table[ hash ].key)) {
            return market;
        }
        if (table[hash] == null) {
            size++;
        }
            this.table[hash] = new Entry<>(key, value, hash);
            this.size++;
            this.modCount++;
            return true;
        }


            /**
             * Метод получения значения по ключу.
             * @param key ключ
             * @return значение по ключу
             */
            public V get(K key) {
               V value = null;
               int hash = key.hashCode() ^ (key.hashCode() >>> 16);
               Entry<K, V> el = this.table[hash];
                if (table[hash] == null && hash == table[hash].hashCode() && key.equals(table[hash])) {
                    return null;
                }
                return table[hash].value;
            }

            /**
             *
             * @param key ключ
             * @return
             */
            public boolean delete(K key) {
                Entry<K, V>[] el = this.table;
                int hash = key.hashCode() ^ (key.hashCode() >>> 16);
                if (table[hash] == null && hash != table[hash].hashCode() && key.equals(table[hash])) {
                    return false;
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
            public Iterator <Entry> iterator() {
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

    public class Entry<K, V> {
        private final K key;
        private final V value;
        private final int hash;

        public Entry(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }
}


