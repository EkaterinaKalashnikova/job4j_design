package ru.job4j.gc;

/*
 JVM хранит для каждого объекта:
1. Заголовок объекта;
2. Память для примитивных типов;
3. Память для ссылочных типов;
4. Смещение/выравнивание — по сути, это несколько неиспользуемых байт,
 что размещаются после данных самого объекта. Это сделано для того,
 чтобы адрес в памяти всегда был кратным машинному слову,
 для ускорения чтения из памяти + уменьшения количества бит
 для указателя на объект + предположительно для уменьшения фрагментации памяти.
 Стоит также отметить, что в java размер любого объекта кратен 8 байтам!
 */

public class User {
    private int id;
    private String name;
    //private String address;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n ", id, name);
    }

    private static void info() {
        final long KB = 1000;
        final long MB = KB * KB;
        Runtime rt = Runtime.getRuntime();
        final long freeMemory = rt.freeMemory();
        final long totalMemory = rt.totalMemory();
        final long maxMemory = rt.maxMemory();
        System.out.println("=== memory state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        info();
        for (int i = 0; i < 10; i++) {
            new User(i, "N" + i);
        }
        System.gc();
        info();
    }
    /* XmxNm выделем ключами нужные нам мегабайт памяти и при создании java- объектов
    сбободная память уменьшается, когда java поймет, что свободной памяти мало для создания объектов,
    сама вызыввает сборщик мусора
     */
}
