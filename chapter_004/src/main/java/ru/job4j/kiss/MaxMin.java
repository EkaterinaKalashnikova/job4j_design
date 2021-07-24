package ru.job4j.kiss;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        // return Collections.max(value, comparator);
       T rslMax = value.get(0);
        for (T v : value) {
            if (comparator.compare(rslMax, v) < 0) {
                 rslMax = v;
            }
        }
        return rslMax;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        //return Collections.min(value, comparator);
        T rslMin = value.get(0);
        for (T v : value) {
            if (comparator.compare(rslMin, v) > 0) {
                rslMin = v;
            }
        }
        return rslMin;
    }

//    public <T> T findMinMax() {
//        return null;
//    }


    public static void main(String[] args) {
        List<Integer> al = List.of(-1, -2, 1, 2, 3, 0, 250, 360, 720);
        MaxMin maxMin = new MaxMin();
        System.out.println(maxMin.max(al, Integer::compareTo));
        System.out.println(maxMin.min(al, Integer::compareTo));
    }
}
