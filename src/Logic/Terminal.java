package Logic;

import java.io.Serializable;

public class Terminal implements Serializable{

	private String id;

	public Terminal(String id) {
		setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return id;
	}

}
