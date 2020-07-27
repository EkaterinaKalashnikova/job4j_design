package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Метод возврата первого значения и удаления его из коллекции
     * если второй стек пуст, то перекладываем в него значения
     * пока не станет пустым первый и первое значение не окажется наверху
     * @return верхнее первое значение возвращаем и удаляем.
     */
    public T poll() {
       if (out.isEmpty()) {
         while (!in.isEmpty()) {
             out.push(in.pop());
         }
       }
        return out.pop();
    }

    /**
     * Метод добавления переданного значения в конец очереди.
     * @param value значение.
     */
    public void push(T value) {
        in.push(value);
    }
}
