package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;


public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();


    /**
     * Метод для вставки обьекта в кеш
     * @param <K>
     * @param <V>
     * @param key ключ в кеше
     * @param value данные
     */
    public void put(K key, V value) throws IOException {
       // SoftReference<V> reference = (SoftReference<V>) load(key);
        SoftReference<V> reference = new SoftReference<>(value);
        cache.put(key, reference);
    }


    /**
     * получение значения по ключу
     * @param <K>
     * @param <V>
     * @param key ключ для поиска с кеша
     * @return Обьект данных храняшийся в кеше
     */
    public V get(K key) {
        if (cache.get(key) == null) {
            System.out.println("Файл загружен в кэш");
            return load(key);
        }
        System.out.println("Содержимое файла получено из кэша");
        return cache.get(key).get();
    }

    protected abstract V load(K key) ;
}
