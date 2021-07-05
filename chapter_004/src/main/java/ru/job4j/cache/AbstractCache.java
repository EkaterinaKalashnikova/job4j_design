package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;


public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    /**
     * Метод для вставки обьекта в кеш
     *
     * @param key   ключ в кеше
     * @param value данные
     */
    public void put(K key, V value) {
        // SoftReference<V> reference = (SoftReference<V>) load(key);
        SoftReference<V> reference = new SoftReference<>(value);
        cache.put(key, reference);
    }

    /**
     * получение значения по ключу
     *
     * @param key ключ для поиска с кеша
     * @return Обьект данных храняшийся в кеше
     */
    public V get(K key) {
        V value = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (value == null) {
            value = load(key);
            put(key, value);
            System.out.println("Файл загружен в кэш");
        }
        return value;
    }

    protected abstract V load(K key);
}


// if (cache.get(key).get() == null) {
//        System.out.println("Файл загружен в кэш");
//        return load(key);
//    }
//        System.out.println("Содержимое файла получено из кэша");
//        return cache.get(key).get();
