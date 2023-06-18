package util;

import Logic.Bus;

public class TableAuxClass {
    private String localidad;
    private String terminal;
    private Bus bus;

    public TableAuxClass(String localidad, String terminal, Bus bus) {
        setLocalidad(localidad);
        setTerminal(terminal);
        setBus(bus);
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

}
