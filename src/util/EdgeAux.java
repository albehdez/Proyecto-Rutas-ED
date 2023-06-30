package util;

public class EdgeAux {
    private double weigth;
    private double posX;
    private double posY;
    private String address;

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
