package Logic;

public class Corner {
    private double x;
    private double y;
    private String id;

    public Corner(double x, double y, String id) {
        setX(x);
        setY(y);
        setId(id);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
