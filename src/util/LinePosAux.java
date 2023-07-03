package util;

public class LinePosAux {
    private double posx;
    private double posy;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LinePosAux(double posx, double posy, String address) {
        this.posx = posx;
        this.posy = posy;
        this.address = address;
    }

    public double getPosx() {
        return posx;
    }

    public void setPosx(double posx) {
        this.posx = posx;
    }

    public double getPosy() {
        return posy;
    }

    public void setPosy(double posy) {
        this.posy = posy;
    }

}
