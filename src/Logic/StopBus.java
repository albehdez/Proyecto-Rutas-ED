package Logic;

import java.io.Serializable;
import java.util.LinkedList;

public class StopBus implements Serializable {

	private String id;
	private double x;
	private double y;

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

	private LinkedList<Object> list;

	public String getId() {
		return id;
	}

	public StopBus(String name, double x, double y) {
		setName(name);
		setX(x);
		setY(y);
	}

	public void setName(String id) {
		if (id != null || !id.equalsIgnoreCase(""))
			this.id = id;
		else
			throw new IllegalArgumentException("Nombre de ruta no valido.");
	}
}
