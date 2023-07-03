package util;

import java.io.Serializable;

public class EdgeAux implements Serializable{
    private double weigth;
    private double posX;
    private double posY;
    private String address;
    private int posCorner1;
    private int posCorner2;
    public int getPosCorner2() {
        return posCorner2;
    }

    public void setPosCorner2(int posCorner2) {
        this.posCorner2 = posCorner2;
    }

    public int getPosCorner1() {
        return posCorner1;
    }

    public void setPosCorner1(int posCorner1) {
        this.posCorner1 = posCorner1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EdgeAux(double weigth, double posX, double posY, String address) {
        setWeigth(weigth);
        setPosX(posX);
        setPosY(posY);
        setAddress(address);
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
