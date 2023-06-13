package util;

import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class Dijktra_node_path {
	private Vertex vertice;
	private Integer costo;
	private Vertex anterior;

	public Dijktra_node_path(Vertex vertice, int costo, Vertex anterior) {
		// TODO Auto-generated constructor stub
		this.vertice = vertice;
		this.costo = costo;
		this.anterior = anterior;
	}

	public Dijktra_node_path(Vertex vertice) {
		// TODO Auto-generated constructor stub
		this.vertice = vertice;
		this.costo = Integer.MAX_VALUE;
		this.anterior = null;
	}

	public boolean isNode(Vertex v) {
		if (v.getInfo().equals(vertice.getInfo())) {
			return true;
		} else {
			return false;
		}
	}

	public Vertex getVertice() {
		return vertice;
	}

	public void setVertice(Vertex vertice) {
		this.vertice = vertice;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Vertex getAnterior() {
		return anterior;
	}

	public void setAnterior(Vertex anterior) {
		this.anterior = anterior;
	}

}
