package util;

import java.util.Comparator;

public class MyComparator<V, T> implements Comparator<Label<Double, T>> {

    @Override
    public int compare(Label<Double, T> o1, Label<Double, T> o2) {
        Double a = o1.getWeigth(), b = o2.getWeigth();
        return a.compareTo(b);
    }

}