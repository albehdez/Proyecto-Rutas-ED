package Logic;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.module.ResolutionException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.Iterator;

import Application.Scene3;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import util.AuxClassBusTable;
import util.AuxClassPath;
import util.Convert;
import util.EdgeAux;
import util.Label;
import util.LinePosAux;
import util.MyComparator;

public class University {

	private static University instance;
	private GeneralTree<Object> tree;
	private ILinkedWeightedEdgeNotDirectedGraph map;
	private File mapFile;
	private File treeFile;

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

	/**
	 * @param Location
	 * @param Terminal
	 * @param Bus
	 * @param seating
	 * @return un boolean que representa true si la insercion se pudo realizar
	 *         correctamente y en caso contrario false
	 */
	public boolean insertBus(String Location, String Terminal, String Bus, int seating) {

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

	/**
	 * @param name
	 * @return
	 */
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

	/**
	 * @param localidad
	 * @param ID
	 * @return
	 */
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

	/**
	 * @param localidad localiad donde se encuentra el omnibus
	 * @param terminal  terminal a la cual pertenece el omnibus
	 * @param tuition   matricula del omnibus
	 * @return un objecto de tipo BinaryTreeNode que contiene el omnibus eliminado
	 */
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

	/**
	 * @param localidad localidad donde se encuantra el omnibus
	 * @param terminal  terminal a la cual pertence el omnibus
	 * @param bus       maticula del omnibus que se desea eliminar
	 * @return
	 */
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

	/**
	 * @return una lista con todos los datos de los omnibus almacenados en el arbol
	 */
	public LinkedList<AuxClassBusTable> getTreeInfo() {
		LinkedList<AuxClassBusTable> list = new LinkedList<AuxClassBusTable>();
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
					AuxClassBusTable info = new AuxClassBusTable(currentLocation, currentTerminal, aux,
							aux.getSeating());
					// info.setLocation(currentLocation);
					// info.setTerminal(currentTerminal);
					// info.setBus(aux);

					list.add(info);
				}
			}
		}
		return list;
	}

	/**
	 * @param a vertice de inicio
	 * @param b vetice final
	 * @return una lista con las etiquetas de los nodos para determinar el camino
	 *         mas corto
	 */
	public ArrayList<Label<Double, Object>> dijkstra(Object a, Object b) {
		int cant = map.getVerticesList().size();
		ArrayList<Label<Double, Object>> labels = new ArrayList<Label<Double, Object>>(cant);

		for (int k = 0; k < cant; k++) {
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

	/**
	 * @param nodoInicial nodo inicial del camino
	 * @param nodoFinal   nodo final del camino
	 * @param labels      lista de etiquetas
	 * @param path        pila que contiene el camino que va guardando
	 */
	private void dijkstraPath(Object nodoInicial, Object nodoFinal, ArrayList<Label<Double, Object>> labels,
			Deque<Object> path) {
		path.push(nodoFinal);
		if (!nodoInicial.equals(nodoFinal)) {
			int posNodoFinal = map.getVerticesList().indexOf(nodoFinal);
			dijkstraPath(nodoInicial, labels.get(posNodoFinal).getNode(), labels, path);
		}
	}

	/**
	 * @param a nodo inicial
	 * @param b nodo final
	 * @return un objeto de tipo AuxClassPath, que es una clase auxiliar, la cual
	 *         contiene una lista con
	 *         el camino mas corto entre los dos nodos que se pasaron por parametros
	 *         y un valor real que contiene el peso de dicho camino.
	 */
	public AuxClassPath shortestPath(Object a, Object b, ILinkedWeightedEdgeNotDirectedGraph graph) {
		AuxClassPath data = new AuxClassPath();

		int posNodoFinal = graph.getVerticesList().indexOf(b);
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

	/**
	 * @param a nodo de inicio
	 * @param b nodo de destino
	 * @return un valor real que representa el peso entre los dos nodos que se
	 *         pasaron por parametros.
	 */
	public double getEdgeWeigth(Vertex a, Vertex b) {
		double weight = 0.0;
		boolean value = false;
		LinkedList<Edge> list = a.getEdgeList();
		ListIterator<Edge> it = list.listIterator();
		while (!value && it.hasNext()) {
			WeightedEdge eaux = (WeightedEdge) it.next();
			if (b.equals(eaux.getVertex())) {
				EdgeAux aux = (EdgeAux) eaux.getWeight();
				weight = aux.getWeigth();
				value = true;
			}
		}
		return weight;
	}

	public EdgeAux getEdgeObject(Vertex a, Vertex b) {
		EdgeAux auxEdge = null;
		// double weight = 0.0;
		boolean value = false;
		LinkedList<Edge> list = a.getEdgeList();
		ListIterator<Edge> it = list.listIterator();
		while (!value && it.hasNext()) {
			WeightedEdge eaux = (WeightedEdge) it.next();
			if (b.equals(eaux.getVertex())) {
				auxEdge = (EdgeAux) eaux.getWeight();
				value = true;
			}
		}
		return auxEdge;
	}

	/**
	 * @param name   nombre de la parada
	 * @param x      coordenada x de la parada
	 * @param y      coordenada y de la parada
	 * @param inicio id vertice inicial de la calle donde se piensa introducir un
	 *               parada
	 * @param fin    id vertice final de la calle donde se piensa introducir un
	 *               parada
	 */
	public void insertStopBus(String name, double x, double y, String inicio, String fin) {
		StopBus route = new StopBus(name, x, y);
		Vertex ini = findVertex(inicio);
		Vertex finl = findVertex(fin);
		int posInicio = map.getVerticesList().indexOf(ini);
		int posFin = map.getVerticesList().indexOf(finl);
		double valueEdge = getEdgeWeigth(ini, finl);
		map.insertVertex(route);
		int newNode = map.getVerticesList().indexOf(route);
		map.deleteEdgeND(posInicio, posFin);
		map.insertWEdgeNDG(posInicio, newNode, new EdgeAux(valueEdge / 2, 0, 0,
				((Corner) ini.getInfo()).getId() + "3" + ((Corner) finl.getInfo()).getId(), posFin, newNode));
		map.insertWEdgeNDG(posInicio, newNode, new EdgeAux(valueEdge / 2, 0, 0,
				((Corner) ini.getInfo()).getId() + "3" + ((Corner) finl.getInfo()).getId(), newNode, posFin));
		saveParada(route);
	}

	public void saveParada(StopBus stopBus) {
		InDepthIterator<Object> it = tree.inDepthIterator();
		boolean value = false;
		while (it.hasNext() && !value) {
			Object o = it.next();
			if (o instanceof Bus) {
				String tuition = (String) Scene3.getInstance().getChoiceBox().getSelectionModel().getSelectedItem();
				if (((Bus) o).getTuition().equals(tuition)) {
					value = true;
					((Bus) o).getRoute().add(stopBus);
				}
			}
		}
	}

	public Vertex searchVertex(double x, double y) {
		Vertex vaux = null;
		ListIterator<Vertex> it = map.getVerticesList().listIterator();
		boolean value = false;
		while (it.hasNext() && !value) {
			vaux = it.next();
			if (vaux.getInfo() instanceof Corner) {
				if (((Corner) vaux.getInfo()).getX() == x && ((Corner) vaux.getInfo()).getY() == y)
					value = true;
			} else {
				if (((StopBus) vaux.getInfo()).getX() == x && ((StopBus) vaux.getInfo()).getY() == y)
					value = true;
			}

		}
		return value ? vaux : null;
	}

	public LinkedList<AuxClassPath> findsRoutes(Vertex v) {
		LinkedList<AuxClassPath> list = new LinkedList<AuxClassPath>();
		ListIterator<Vertex> it = map.getVerticesList().listIterator();
		while (it.hasNext()) {
			double comp = -1;
			Vertex aux = it.next();
			AuxClassPath auxClass = null;
			if (aux.getInfo() instanceof StopBus) {
				// auxClass = shortestPath(v, aux);
				if (comp == -1) {
					list.add(auxClass);
					comp = auxClass.getWeigth();
				} else if (auxClass.getWeigth() < comp) {
					list.add(auxClass);
					comp = auxClass.getWeigth();
				} else if (auxClass.getWeigth() == comp) {
					list.add(auxClass);
				}
			}
		}
		return list;
	}

	public LinkedList<LinePosAux> findWay(LinkedList<Object> wayList) {
		LinkedList<LinePosAux> list = new LinkedList<LinePosAux>();
		ListIterator<Object> it = wayList.listIterator();
		Vertex aux1 = (Vertex) it.next();
		while (it.hasNext()) {
			Vertex aux2 = (Vertex) it.next();
			EdgeAux eaux = getEdgeObject(aux1, aux2);
			list.add(new LinePosAux(eaux.getPosX(), eaux.getPosY(), eaux.getAddress()));
			aux1 = aux2;
		}
		return list;
	}

	public ILinkedWeightedEdgeNotDirectedGraph insertUbication(double posX, double posY, String corner1,
			String corner2) {

		Corner cUbication = new Corner(posX, posY, "yourUbication");
		ILinkedWeightedEdgeNotDirectedGraph grapAux = getMap();
		Vertex v1 = findVertex(corner1);
		Vertex v2 = findVertex(corner2);
		int posCorner1 = grapAux.getVerticesList().indexOf(findVertex(corner1));
		int posCorner2 = grapAux.getVerticesList().indexOf(findVertex(corner2));
		double weight = getEdgeWeigth(v1, v2);
		grapAux.deleteEdgeND(posCorner1, posCorner2);
		grapAux.insertVertex(cUbication);
		int posUbication = grapAux.getVerticesList().indexOf(findVertex(cUbication.getId()));
		grapAux.insertWEdgeNDG(posCorner1, posUbication,
				new EdgeAux(weight / 2, posX, posY, null, posCorner1, posCorner2));
		grapAux.insertWEdgeNDG(posUbication, posCorner2,
				new EdgeAux(weight / 2, posX, posY, null, posCorner1, posCorner2));
		return grapAux;
	}

	public void deleteUbication(double posx, double posy, String corner1, String corner2) {
		int posCorner1 = map.getVerticesList().indexOf(findVertex(corner1));
		int posCorner2 = map.getVerticesList().indexOf(findVertex(corner2));
		int posUbication = map.getVerticesList().indexOf(findVertex("yourUbication"));
		Vertex v1 = findVertex(corner1);
		Vertex v2 = findVertex("yourUbication");
		double weight = getEdgeWeigth(v1, v2) * 2;
		map.deleteEdgeND(posCorner1, posUbication);
		map.deleteEdgeND(posCorner2, posUbication);
		map.insertWEdgeNDG(posCorner2, posCorner1,
				new EdgeAux(weight, posx, posy, corner1 + "3" + corner2, posCorner1, posCorner2));
		map.deleteVertex(posUbication);
	}

	public Vertex findVertex(String id) {
		Vertex aux = null;
		boolean value = false;
		ListIterator<Vertex> it = map.getVerticesList().listIterator();
		while (it.hasNext() && !value) {
			aux = it.next();
			if (aux.getInfo() instanceof Corner) {
				if (((Corner) aux.getInfo()).getId().equals(id))
					value = true;
			} else if (aux.getInfo() instanceof StopBus) {
				if (((StopBus) aux.getInfo()).getId().equals(id))
					value = true;
			}
		}
		return value ? aux : null;
	}

	public LinkedList<Bus> getTreeBus() {
		LinkedList<Bus> list = new LinkedList<Bus>();
		InDepthIterator<Object> it = tree.inDepthIterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof Bus)
				list.add((Bus) o);

		}
		return list;
	}

	public AuxClassPath findStopBusShort(ILinkedWeightedEdgeNotDirectedGraph grapAux) {
		ListIterator<Vertex> it = grapAux.getVerticesList().listIterator();
		double comp = Double.MAX_VALUE;
		AuxClassPath a = null;
		AuxClassPath aux = null;
		while (it.hasNext()) {
			Vertex v = it.next();
			if (v.getInfo() instanceof StopBus) {
				a = University.getInstance().shortestPath(
						University.getInstance().findVertex("yourUbication"),
						University.getInstance().searchVertex((((StopBus) v.getInfo()).getX()),
								(((StopBus) v.getInfo()).getY())),
						grapAux);
				if (a.getWeigth() < comp)
					aux = a;
			}
		}
		return aux;
	}

}