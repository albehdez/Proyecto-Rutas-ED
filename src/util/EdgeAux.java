package util;

public class EdgeAux {
    private double weigth;
    private double posX;
    private double posY;

    public EdgeAux(double weigth, double posX, double posY) {
        this.weigth = weigth;
        this.posX = posX;
        this.posY = posY;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

}
