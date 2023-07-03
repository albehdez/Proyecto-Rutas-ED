package Logic;

import java.io.Serializable;
import java.util.LinkedList;

public class Bus implements Serializable{
	
	private String tuition;
	private LinkedList<StopBus> route;

	public LinkedList<StopBus> getRoute() {
		return route;
	}

	private int seating;

	public int getSeating() {
		return seating;
	}

	public void setSeating(int seating) {
		this.seating = seating;
	}

	public Bus(String tuition, int seating) {
		setTuition(tuition);
		route = new LinkedList<StopBus>();
		setSeating(seating);
	}

	public String getTuition() {
		return tuition;
	}

	public void setTuition(String tuition) {
		if (tuition != null)
			this.tuition = tuition;
	}

	public String toString() {
		return tuition;
	}

}
