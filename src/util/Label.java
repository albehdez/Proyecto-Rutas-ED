package util;

public class Label<Double, T> {
    private double weigth;
    private Object node;

    public Label(double weigth, Object node) {
        setWeigth(weigth);
        setNode(node);
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public Object getNode() {
        return node;
    }

    public void setNode(Object node) {
        this.node = node;
    }

}
