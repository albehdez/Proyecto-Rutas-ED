package util;

import java.util.LinkedList;

public class AuxClassPath {
    private LinkedList<Object> list;
    private double weigth;

    public AuxClassPath() {
        list = new LinkedList<Object>();
        this.weigth = 0;
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

}
