package Logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.Iterator;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import javafx.scene.layout.Priority;
import javafx.util.Pair;
import util.AuxC4Table;
import util.AuxClassPath;
import util.Label;
import util.MyComparator;

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

	private InDepthIterator<Object> inDepthIterator() {
		return new InDepthIterator<Object>(this.tree);
	}

	public boolean insert(String Location, String Terminal, String Bus, int seating) {

		boolean retB = false;
		if (this.tree.isEmpty()) {

			Location location = new Location(Location);
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
				Location location = new Location(Location);
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
				if (((Location) aux.getInfo()).getName().equalsIgnoreCase(name)) {
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
				if (((Location) aux.getInfo()).getName().equalsIgnoreCase(localidad)) {
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
				if (((Location) aux.getInfo()).getName().equalsIgnoreCase(localidad)) {
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
								if (((Location) aux.getInfo()).getName()
										.equalsIgnoreCase(((Location) nodeLocalidad.getInfo()).getName())) {
									this.tree.setRoot(aux.getRight());
								} else {
									while (!stop && aux != null) {
										if (((Location) aux.getRight().getInfo()).getName()
												.equalsIgnoreCase(((Location) nodeLocalidad.getInfo()).getName())) {
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

	public LinkedList<AuxC4Table> getNodesInfo() {
		LinkedList<AuxC4Table> list = new LinkedList<AuxC4Table>();
		Location currentLocation = null;
		Terminal currentTerminal = null;
		Object current = null;

		if (!this.tree.isEmpty()) {
			InDepthIterator<Object> iter = inDepthIterator();
			while (iter.hasNext()) {
				current = iter.next();
				if (current instanceof Location) {
					Location aux = ((Location) current);

					if (currentLocation == null) {
						currentLocation = aux;

					} else if (aux != currentLocation) {
						currentLocation = aux;
					}

				} else if (current instanceof Terminal) {
					Terminal aux = (Terminal) current;

					if (currentTerminal == null) {
						currentTerminal = aux;
					} else if (aux != currentTerminal) {
						currentTerminal = aux;
					}
				} else if (current instanceof Bus) {
					Bus aux = (Bus) current;
					AuxC4Table info = new AuxC4Table();
					info.setLocation(currentLocation);
					info.setTerminal(currentTerminal);
					info.setBus(aux);

					list.add(info);
				}
			}
		}
		return list;
	}

	public ArrayList<Label<Double, Object>> dijkstra(Object a, Object b) {
		ArrayList<Label<Double, Object>> labels = new ArrayList<Label<Double, Object>>(map.getVerticesList().size());

		for (Vertex v : map.getVerticesList()) {
			labels.add(new Label<>(Double.MAX_VALUE, null));
		}

		PriorityQueue<Label<Double, Object>> queue = new PriorityQueue<Label<Double, Object>>(new MyComparator());

		int posInitial = map.getVerticesList().indexOf(a);
		labels.set(posInitial, new Label<Double, Object>(0, a));
		queue.add(new Label<Double, Object>(0, a));
		Object minValue = null;
		while (!queue.isEmpty() && !b.equals(minValue)) {
			minValue = queue.peek().getNode();
			// int postFinal = map.getVerticesList().indexOf(b);
			int posMinLabel = map.getVerticesList().indexOf(queue.peek().getNode());
			for (Object i : map.adjacentsG(posMinLabel)) {
				double cost = getEdgeWeigth(map.getVerticesList().get(posMinLabel), (Vertex) i);
				int auxpos = map.getVerticesList().lastIndexOf(i);
				if (labels.get(auxpos).getWeigth() > labels.get(posMinLabel).getWeigth() + cost) {
					labels.set(auxpos, new Label<>(labels.get(posMinLabel).getWeigth() + cost, minValue));
					queue.add(new Label<Double, Object>(labels.get(posMinLabel).getWeigth() + cost, i));
				}
			}
			queue.poll();
		}

		return labels;
	}

	private void dijkstraPath(Object nodoInicial, Object nodoFinal, ArrayList<Label<Double, Object>> labels,
			Deque<Object> path) {
		path.push(nodoFinal);
		if (!nodoInicial.equals(nodoFinal)) {
			int posNodoFinal = map.getVerticesList().indexOf(nodoFinal);
			dijkstraPath(nodoInicial, labels.get(posNodoFinal).getNode(), labels, path);
		}
	}

	public AuxClassPath dijkstraQuery(Object a, Object b) {
		AuxClassPath data = new AuxClassPath();

		int posNodoFinal = map.getVerticesList().indexOf(b);
		ArrayList<Label<Double, Object>> dist = dijkstra(a, b);
		Deque<Object> path = new ArrayDeque<Object>();
		dijkstraPath(a, b, dist, path);
		double cant = 0;
		cant = cant + dist.get(posNodoFinal).getWeigth();
		data.setWeigth(cant);
		while (!path.isEmpty()) {
			data.getList().add(path.pop());
		}
		return data;
	}

	public double getEdgeWeigth(Vertex a, Vertex b) {
		double weight = -1;
		boolean value = false;
		LinkedList<Edge> list = a.getEdgeList();
		ListIterator<Edge> it = list.listIterator();
		while (!value && it.hasNext()) {
			WeightedEdge eaux = (WeightedEdge) it.next();
			if (b.equals(eaux.getVertex())) {
				weight = (double) eaux.getWeight();
				value = true;
			}
		}
		return weight;
	}
}