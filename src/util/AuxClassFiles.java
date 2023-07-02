package util;

public class AuxClassFiles<Object> {
    private Object info;
    private int rightSon;
    private boolean isLeaf;

    public AuxClassFiles(Object info, int rightSon, boolean isLeaf) {
        this.info = info;
        this.rightSon = rightSon;
        this.isLeaf = isLeaf;
    }

    public Object getInfo() {
        return info;
    }

    public int getRightSon() {
        return rightSon;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

}