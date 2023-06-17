package Logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedDirectedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

public class University {

	private static University instance;
	private GeneralTree<Object> tree;
	private ILinkedWeightedEdgeNotDirectedGraph map;

	public ILinkedWeightedEdgeNotDirectedGraph getMap() {
		return map;
	}

	private University() {
		tree = new GeneralTree<Object>();
		map = new LinkedGraph();
	}

	public static University getInstance() {
		if (instance == null)
			instance = new University();
		return instance;
	}

	public GeneralTree<Object> getTree() {
		return tree;
	}

	// // metodo iniciado por Alberto
	// public void addBus(String location, String tuition, String terminal) {
	// Terminal t = new Terminal(terminal);
	// Bus b = new Bus(tuition);
	// TerminalLocation l = new TerminalLocation(location);
	// BinaryTreeNode<TreeNode> bt = new BinaryTreeNode<Object>(t);
	// BinaryTreeNode<TreeNode> bb = new BinaryTreeNode<TreeNode>(b);
	// BinaryTreeNode<TreeNode> bl = new BinaryTreeNode<TreeNode>(l);

	// if (tree.isEmpty()) {

	// tree.insertNode(bl, null);
	// tree.insertNode(bt, bl);
	// tree.insertNode(bb, bt);
	// } else {
	// boolean value = true;
	// BinaryTreeNode<Object> aux = (BinaryTreeNode) tree.getRoot();
	// while (aux != null && value) {
	// if (((TerminalLocation) aux.getInfo()).getName().equals(location))
	// value = false;
	// aux = aux.getRight();
	// }
	// if (value) {

	// }
	// }

	// }

	// private BinaryTreeNode<Object> searchNode(String id) {
	// BinaryTreeNode<Object> rNode = null;
	// if (!this.tree.isEmpty()) {
	// InDepthIterator<Object> iterator = inDepthIterator();
	// boolean stop = false;
	// while (iterator.hasNext() && !stop) {
	// BinaryTreeNode<Object> iterNode = iterator.nextNode();
	// if (iterNode.getInfo() instanceof LocationT) {
	// if (((LocationT) iterNode.getInfo()).getName().equals(id)) {
	// stop = true;
	// rNode = iterNode;

	// }
	// } else if (iterNode.getInfo() instanceof Terminal) {
	// if (((Terminal) iterNode.getInfo()).getId().equals(id)) {
	// stop = true;
	// rNode = iterNode;

	// }
	// }
	// }
	// }
	// return rNode;
	// }

	private InDepthIterator<Object> inDepthIterator() {
		return new InDepthIterator<Object>(this.tree);
	}

	// public Stack<Vertex> Shortest_Path(Vertex start, Vertex end) {
	// if (start.getEdgeList().size() == 0 || end.getEdgeList().size() == 0) {
	// return null;
	// }
	// // creando y llenado listas
	// ArrayList<Vertex> noVisitados = new
	// ArrayList<>(grafo.getVerticesList().size());
	// Stack<Vertex> result = new Stack<Vertex>();
	// ArrayList<Dijktra_node_path> registro = new
	// ArrayList<>(grafo.getVerticesList().size());
	// Iterator<Vertex> verIter = grafo.getVerticesList().iterator();
	// Map<String, Dijktra_node_path> mapaReg = new HashMap<>();
	// Dijktra_node_path temp2 = null;

	// while (verIter.hasNext()) {
	// Vertex temp = verIter.next();

	// noVisitados.add(temp);

	// if (temp.getInfo().equals(start.getInfo()))// si es el nodo inicial
	// {
	// temp2 = new Dijktra_node_path(temp, 0, null);// la 1era fila se llena con los
	// valores nodo/distancia = 0
	// // xq estoy en el inicio y nodo anterior null,pues no
	// // hay anterior
	// } else {
	// temp2 = new Dijktra_node_path(temp);
	// }
	// mapaReg.put(((Parada) temp2.getVertice().getInfo()).getID(), temp2);
	// registro.add(temp2);// se agrega en cada posicion una fila y se conforma la
	// tabla como tal
	// }

	// // comienza la logica
	// int cont = 500;
	// LinkedList<Edge> adj = null;
	// Iterator<Edge> ite = null;
	// WeightedEdge arco;
	// Vertex nodoAnalizandose = null;
	// Vertex vertex = null;

	// while (noVisitados.size() != 0) {
	// nodoAnalizandose = BuscarMenor(noVisitados, mapaReg);
	// adj = nodoAnalizandose.getEdgeList();
	// ite = adj.iterator();
	// while (ite.hasNext()) {
	// arco = (WeightedEdge) ite.next();
	// vertex = arco.getVertex();
	// Dijktra_node_path regNodoAdyacente = mapaReg.get(((Parada)
	// vertex.getInfo()).getID());
	// Dijktra_node_path regNodoAnalizandose = mapaReg.get(((Parada)
	// nodoAnalizandose.getInfo()).getID());

	// // si el arco es correcto, hay q buscar en el arreglo de paradas,cada vertice
	// es
	// // una parada
	// if (SonSucesivos(nodoAnalizandose, vertex)) {
	// // llenar la 2da columna con el peso del camino y la 3era con el nodo
	// anterior
	// // para cada fila
	// // hay que buscar el indice en el que esta el vertice q estoy analizando
	// if (regNodoAnalizandose.getCosto() != Integer.MAX_VALUE && regNodoAdyacente
	// .getCosto() > regNodoAnalizandose.getCosto() + (Integer) arco.getWeight()) {
	// regNodoAdyacente.setCosto(regNodoAnalizandose.getCosto() + (Integer)
	// arco.getWeight());
	// regNodoAdyacente.setAnterior(nodoAnalizandose);
	// mapaReg.put(((Parada) regNodoAdyacente.getVertice().getInfo()).getID(),
	// regNodoAdyacente);
	// cont = 500;
	// }
	// } else if ((Integer) arco.getWeight() <= cont) {
	// if (regNodoAnalizandose.getCosto() != Integer.MAX_VALUE && regNodoAdyacente
	// .getCosto() > regNodoAnalizandose.getCosto() + (Integer) arco.getWeight()) {
	// regNodoAdyacente.setCosto(regNodoAnalizandose.getCosto() + (Integer)
	// arco.getWeight());
	// regNodoAdyacente.setAnterior(nodoAnalizandose);
	// mapaReg.put(((Parada) regNodoAdyacente.getVertice().getInfo()).getID(),
	// regNodoAdyacente);
	// cont -= (Integer) arco.getWeight();
	// }
	// }
	// }
	// noVisitados.remove(nodoAnalizandose);
	// // nodoAnalizandose = BuscarMenor(noVisitados,mapaReg);
	// // adj = nodoAnalizandose.getEdgeList();
	// }

	// if (mapaReg.get(((Parada) end.getInfo()).getID()).getCosto() ==
	// Integer.MAX_VALUE) {
	// result = null;

	// } else {
	// result.push(end);
	// Vertex otroTemp = mapaReg.get(((Parada)
	// end.getInfo()).getID()).getAnterior();
	// while (mapaReg.get(((Parada) otroTemp.getInfo()).getID()).getAnterior() !=
	// null) {
	// result.push(otroTemp);
	// otroTemp = mapaReg.get(((Parada) otroTemp.getInfo()).getID()).getAnterior();
	// }
	// result.push(otroTemp);
	// }

	// return result;
	// }

	public boolean insert(String Location, String Terminal, String Bus, int seating) {

		boolean retB = false;
		if (this.tree.isEmpty()) {

			LocationT location = new LocationT(Location);
			BinaryTreeNode<Object> nodeLocation = new BinaryTreeNode<Object>(location);
			this.tree.insertNode(nodeLocation, null);

			Terminal terminal = new Terminal(Terminal);
			BinaryTreeNode<Object> nodeTerminal = new BinaryTreeNode<Object>(terminal);
			this.tree.insertNode(nodeTerminal, nodeLocation);

			Bus bus = new Bus(Bus, seating);
			bus.setSeating(seating);
			BinaryTreeNode<Object> nodeBus = new BinaryTreeNode<Object>(bus);
			this.tree.insertNode(nodeBus, nodeTerminal);
			retB = true;

		} else {
			BinaryTreeNode<Object> node1 = searchLocalidad(Location);
			if (node1 != null) {
				BinaryTreeNode<Object> node2 = searchTerminal(Location, Terminal);
				if (node2 != null) {
					BinaryTreeNode<Object> node3 = searchBus(Location, Terminal, Bus);
					if (node3 != null) {
						throw new IllegalArgumentException("El bus ya existe");
					} else {
						Bus bus = new Bus(Bus, seating);
						bus.setSeating(seating);
						BinaryTreeNode<Object> nodeBus = new BinaryTreeNode<Object>(bus);
						this.tree.insertNode(nodeBus, node2);
						retB = true;
					}
				} else {
					Terminal terminal = new Terminal(Terminal);
					BinaryTreeNode<Object> nodeTerminal = new BinaryTreeNode<Object>(terminal);
					this.tree.insertNode(nodeTerminal, node1);
					Bus bus = new Bus(Bus, seating);
					bus.setSeating(seating);
					BinaryTreeNode<Object> nodeBus = new BinaryTreeNode<Object>(bus);
					this.tree.insertNode(nodeBus, nodeTerminal);
					retB = true;
				}
			} else {
				LocationT location = new LocationT(Location);
				BinaryTreeNode<Object> nodeLocation = new BinaryTreeNode<Object>(location);
				this.tree.insertNode(nodeLocation, null);

				Terminal terminal = new Terminal(Terminal);
				BinaryTreeNode<Object> nodeTerminal = new BinaryTreeNode<Object>(terminal);
				this.tree.insertNode(nodeTerminal, nodeLocation);

				Bus bus = new Bus(Bus, seating);
				bus.setSeating(seating);
				BinaryTreeNode<Object> nodeBus = new BinaryTreeNode<Object>(bus);
				this.tree.insertNode(nodeBus, nodeTerminal);
				retB = true;
			}
		}
		return retB;

	}

	private BinaryTreeNode<Object> searchLocalidad(String name) {
		BinaryTreeNode<Object> rNode = null;

		if (!this.tree.isEmpty()) {
			BinaryTreeNode<Object> aux = (BinaryTreeNode<Object>) this.tree.getRoot();
			boolean stop = false;
			while (!stop && aux != null) {
				if (((LocationT) aux.getInfo()).getName().equalsIgnoreCase(name)) {
					rNode = aux;
					stop = true;
				}
				aux = aux.getRight();
			}
		}

		return rNode;
	}

	private BinaryTreeNode<Object> searchTerminal(String localidad, String ID) {
		BinaryTreeNode<Object> rNode = null;

		if (!this.tree.isEmpty()) {
			BinaryTreeNode<Object> aux = (BinaryTreeNode<Object>) this.tree.getRoot();
			boolean stop = false;
			while (!stop && aux != null) {
				if (((LocationT) aux.getInfo()).getName().equalsIgnoreCase(localidad)) {
					stop = true;
					boolean stop2 = false;
					BinaryTreeNode<Object> aux2 = aux.getLeft();
					while (aux2 != null && !stop2) {
						if (((Terminal) aux2.getInfo()).getId().equalsIgnoreCase(ID)) {
							stop2 = true;
							rNode = aux2;
						}
						aux2 = aux2.getRight();
					}

				}
				aux = aux.getRight();
			}
		}

		return rNode;
	}

	private BinaryTreeNode<Object> searchBus(String localidad, String terminal, String tuition) {
		BinaryTreeNode<Object> rNode = null;

		if (!this.tree.isEmpty()) {
			BinaryTreeNode<Object> aux = (BinaryTreeNode<Object>) this.tree.getRoot();
			boolean stop = false;
			while (!stop && aux != null) {
				if (((LocationT) aux.getInfo()).getName().equalsIgnoreCase(localidad)) {
					stop = true;
					boolean stop2 = false;
					BinaryTreeNode<Object> aux2 = aux.getLeft();
					while (aux2 != null && !stop2) {
						if (((Terminal) aux2.getInfo()).getId().equalsIgnoreCase(terminal)) {
							stop2 = true;
							boolean stop3 = false;
							BinaryTreeNode<Object> aux3 = aux2.getLeft();
							while (aux3 != null && !stop3) {
								if (((Bus) aux3.getInfo()).getTuition().equalsIgnoreCase(tuition)) {
									stop3 = true;
									rNode = aux3;
								}
								aux3 = aux3.getRight();
							}
						}
						aux2 = aux2.getRight();
					}

				}
				aux = aux.getRight();
			}
		}

		return rNode;
	}

	public boolean deleteBus(String localidad, String terminal, String bus) {
		boolean deleted = false;
		if (!tree.isEmpty()) {
			BinaryTreeNode<Object> nodeLocalidad = searchLocalidad(localidad);
			if (nodeLocalidad != null) {
				BinaryTreeNode<Object> nodeTerminal = searchTerminal(localidad, terminal);
				if (nodeTerminal != null) {
					BinaryTreeNode<Object> nodeBus = searchBus(localidad, terminal, bus);
					if (nodeBus != null) {
						tree.deleteNode(nodeBus);
						deleted = true;
						if (nodeTerminal.getLeft() == null) {
							tree.deleteNode(nodeTerminal);
							if (nodeLocalidad.getLeft() == null) {
								BinaryTreeNode<Object> aux = (BinaryTreeNode<Object>) this.tree.getRoot();

								boolean stop = false;
								if(((Location)aux.getInfo()).getName().equalsIgnoreCase(((Location)nodeLocalidad.getInfo()).getName())){
									this.tree.setRoot(aux.getRight());
								}
								else{
									while (!stop && aux != null) {
										if (((LocationT) aux.getRight().getInfo()).getName()
												.equalsIgnoreCase(((LocationT) nodeLocalidad.getInfo()).getName())) {
											aux.setRight(aux.getRight().getRight());
											stop = true;
										}
										aux = aux.getRight();
									}
								}
								
							}
						}
					} else {
						throw new IllegalArgumentException("El bus que desea eliminar no existe");
					}
				} else {
					throw new IllegalArgumentException("La terminal insertada no existe");
				}
			} else {
				throw new IllegalArgumentException("La localidad insertada no existe");
			}

		} else {
			throw new IllegalArgumentException("El árbol esta vació");
		}

		return deleted;
	}
}