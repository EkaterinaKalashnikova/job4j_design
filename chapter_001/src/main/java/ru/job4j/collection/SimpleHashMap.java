package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Entry> {

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
    private short h;

    /**
     * Конструктор, инициализирующий контейнер SimpleHashMap
     * c первоначальными размерами и учитывающий предельную загрузку.
     */
    public SimpleHashMap() {
        this.table = new Entry[ (int) CAPACITY ];
        this.threshold = (int) (CAPACITY * LOAD_FACTOR);
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
     * Проверяем, если размер массива превышает предельное количество элеентов, то
     * вызываем метод расширения контейнера resize().
     * Проверив, что ключ не null, вычисляем на основе ключа хэш, проверяем на равентсво null,
     * хешей и значений, если не null, возвращаем false, иначе добавляем
     * если совпадений нет, добавляем новый элемент.
     * если элемент с ключом null, то его значение перезаписываем.
     * @param key ключ
     * @param value значение
     * @return
     */
     public boolean insert(K key, V value) {
         boolean flag = false;
         if (key == null) {
             return false;
         }
         if (size + 1 >= threshold) {
             this.resize();
         }
         int index = indexFor(hash(key.hashCode()), this.table.length);
         Entry<K, V> el = this.table[index];
         if (table[index] != null && el.hash == h && el.key.equals(key)) {
             el.value = value;
             this.modCount++;
             return false;
         }
         this.table[index] = new Entry<>(key, value, index);
         this.modCount++;
         this.size++;
         return true;
     }

    /**
     * Метод генерации хэш-кода  в обеспечение хорошего разброса битов
     * @param h  Первый сдвиг xor на 20 позиций со вторым сдвигом на 12 позиций создает маску,
     *           которая может перевернуть 0 или более нижних 20 битов int. Таким образом, вы можете получить
     *           некоторую случайность, вставленную в нижние биты, которая использует потенциально лучше
     *           распределенные старшие биты.
     * @return Второй сдвиг на 7 позиций x или сдвиг на 4 позиции создает маску, которая может
     * перевернуть 0 или более из нижних 28 бит, что снова вносит некоторую случайность
     * в младшие биты и некоторые из более значимых битов, используя предыдущий xor
     * который уже касался некоторых распределений в младших битах. Конечным результатом является
     * более плавное распределение битов по хеш-значению.
     */
    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
       return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Метод нахождения нужной ячейки
     * @param h хэш-код, полученный в результате работы hashCode()
     * @param length длина внутреннего массива(количество ячеек)
     * @return хэш-код - побитовое И - длина массива
     */
    public int indexFor(int h, int length) {
        return h & (length - 1);
    }

    /**
     * Метод расширения контейнера.
     * Проверяем, если размер массива, деленный на размер хранилища превышает предельное количество элементов,
     * то сохраняем ссылку на старую таблицу, в массив записываем ссылку на новую таблицу, увеличивая размер вдвое,
     * затем присваиваем ее новой таблице, обходим старую таблицу. Проверяем, что она содердит не null Entry элемементов,
     * получаем хэш для новой таблицы(ключ и значение), и по этому хэшу помещаем новую Entry в новую таблицу.
     */
     private  void resize() {
         Entry<K, V>[] oldTable = this.table;
         int oldSize = this.table.length;
         int newSize = oldSize * 2;
         this.threshold = (int) (newSize * LOAD_FACTOR);
         Entry<K, V>[] newTable =  new Entry[newSize];
         this.table = newTable;
         for (int i = 0; i  < oldTable.length; i++) {
             Entry<K, V> el = oldTable[i];
             if (el != null) {
                 newTable[el.hash & (newSize - 1)] = el;
                 oldTable[i] = null;
             }
         }
     }

    /**
     * Метод получение значений по ключу.
      * @param key ключ
     * @return полученное значение
     */
      public V get(K key) {
           int index = indexFor(hash(key.hashCode()), this.table.length);
             if (table[index] == null || !(key.equals(table[index].key))) {
                    return null;
                }
                return table[index].value;
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
           int index = indexFor(hash(key.hashCode()), this.table.length);
          //  if (table[index] == null || !(key.equals(table[index].key))
          //       && table[index].key.hashCode() == key.hashCode()) {
          if (Objects.equals(table[index].key, key)) {
               V value = table[index].value;
               table[index] = null;
               modCount++;
               size--;
               return true;
           }
           return  false;
       }

            /**
             * Returns an iterator over elements of type {@code T}.
             *
             * @return an Iterator.
             */
            @Override
            public Iterator<Entry> iterator() {
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
                        boolean mark = false;
                       for (int i = cursor; i < table.length - 1; i++) {
                           if (table[i] != null) {
                               cursor = i;
                              mark = true;
                              break;
                           }
                       }
                        return mark;
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

    public static class Entry<K, V>  {
        private final K key;
        private V value;
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




