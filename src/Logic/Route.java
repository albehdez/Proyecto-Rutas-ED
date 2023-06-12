package Logic;

import java.util.LinkedList;

public class Route {

	private String name;
	private LinkedList<Object> list;

	public Route(String name) {

	}

	public void setName(String name) {
		if (name != null || !name.equalsIgnoreCase(""))
			this.name = name;
		else
			throw new IllegalArgumentException("Nombre de ruta no valido.");
	}
}
