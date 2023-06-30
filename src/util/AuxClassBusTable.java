package util;

import Logic.Location;
import Logic.Terminal;
import Logic.Bus;

public class AuxClassBusTable {
    Location location;
    Terminal terminal;
    Bus bus;
    int cantSeats;

    public int getCantSeats() {
        return cantSeats;
    }

    public void setCantSeats(int cantAsientos) {
        this.cantSeats = cantAsientos;
    }

    public AuxClassBusTable(Location location, Terminal terminal, Bus bus, int cantAsientos) {
        setLocation(location);
        setCantSeats(cantAsientos);
        setTerminal(terminal);
        setBus(bus);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Location getLocation() {
        return this.location;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public Bus getBus() {
        return this.bus;
    }

}
