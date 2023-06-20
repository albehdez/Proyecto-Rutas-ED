package util;




import Logic.Location;
import Logic.Terminal;
import Logic.Bus;



public class AuxC4Table {
    Location location;
    Terminal terminal;
    Bus bus;

    public AuxC4Table(){
        location=null;
        terminal=null;
        bus=null;
    }

    public void setLocation(Location location){
        this.location=location;
    }
    public void setTerminal(Terminal terminal){
        this.terminal=terminal;
    }
    public void setBus(Bus bus){
        this.bus=bus;
    }
    public Location getLocation(){
        return this.location;
    }
    public Terminal getTerminal(){
        return terminal;
    }
    public Bus getBus(){
        return this.bus;
    }
    
}
