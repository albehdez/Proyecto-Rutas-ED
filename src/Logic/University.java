package Logic;

import java.io.File;
import java.io.RandomAccessFile;
import java.lang.module.ResolutionException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Iterator;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeDirectedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;
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
	private File fileTree;
	private File fileGraphVertex;
	private File fileGraphEdge;

	private University() {
		tree = new GeneralTree<Object>();
		// BinaryTreeNode<Object> aux = (BinaryTreeNode<Object>) tree.getRoot();
		map = new LinkedGraph();
		this.fileTree = new File("src/Files/FicheroB.data");
		this.fileGraphVertex = new File("src/Files/FicheroV.data");
		this.fileGraphEdge = new File("src/Files/FicheroE.data");
	}

	public File getFileGraphVertex() {
		return fileGraphVertex;
	}

	public void setFileGraphVertex(File fileGraph) {
		this.fileGraphVertex = fileGraph;
	}

	public File getFileGraphEdge() {
		return fileGraphEdge;
	}

	public void setFileGraphEdge(File fileGraph) {
		this.fileGraphEdge = fileGraph;
	}

	public ILinkedWeightedEdgeNotDirectedGraph getMap() {
		return map;
	}

	public static University getInstance() {
		if (instance == null)
			instance = new University();
		return instance;
	}

	public GeneralTree<Object> getTree() {
		return tree;
	}

	public File getFileTree() {
		return fileTree;
	}

	public void setFileTree(File file) {
		this.fileTree = file;
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
	// public boolean insertBus(String Location, String Terminal, String Bus, int
	// seating) {

	// boolean retB = false;
	// if (this.tree.isEmpty()) {

	// Location location = new Location(Location);
	// BinaryTreeNode<Object> nodeLocation = new BinaryTreeNode<Object>(location);
	// this.tree.insertNode(nodeLocation, null);

	// Terminal terminal = new Terminal(Terminal);
	// BinaryTreeNode<Object> nodeTerminal = new BinaryTreeNode<Object>(terminal);
	// this.tree.insertNode(nodeTerminal, nodeLocation);

	// Bus bus = new Bus(Bus, seating);
	// bus.setSeating(seating);
	// BinaryTreeNode<Object> nodeBus = new BinaryTreeNode<Object>(bus);
	// this.tree.insertNode(nodeBus, nodeTerminal);
	// retB = true;

	// } else {
	// BinaryTreeNode<Object> node1 = searchLocalidad(Location);
	// if (node1 != null) {
	// BinaryTreeNode<Object> node2 = searchTerminal(Location, Terminal);
	// if (node2 != null) {
	// BinaryTreeNode<Object> node3 = searchBus(Location, Terminal, Bus);
	// if (node3 != null) {
	// throw new IllegalArgumentException("El bus ya existe");
	// } else {
	// Bus bus = new Bus(Bus, seating);
	// bus.setSeating(seating);
	// BinaryTreeNode<Object> nodeBus = new BinaryTreeNode<Object>(bus);
	// this.tree.insertNode(nodeBus, node2);
	// retB = true;
	// }
	// } else {
	// Terminal terminal = new Terminal(Terminal);
	// BinaryTreeNode<Object> nodeTerminal = new BinaryTreeNode<Object>(terminal);
	// this.tree.insertNode(nodeTerminal, node1);
	// Bus bus = new Bus(Bus, seating);
	// bus.setSeating(seating);
	// BinaryTreeNode<Object> nodeBus = new BinaryTreeNode<Object>(bus);
	// this.tree.insertNode(nodeBus, nodeTerminal);
	// retB = true;
	// }
	// } else {
	// Location location = new Location(Location);
	// BinaryTreeNode<Object> nodeLocation = new BinaryTreeNode<Object>(location);
	// this.tree.insertNode(nodeLocation, null);

	// Terminal terminal = new Terminal(Terminal);
	// BinaryTreeNode<Object> nodeTerminal = new BinaryTreeNode<Object>(terminal);
	// this.tree.insertNode(nodeTerminal, nodeLocation);

	// Bus bus = new Bus(Bus, seating);
	// bus.setSeating(seating);
	// BinaryTreeNode<Object> nodeBus = new BinaryTreeNode<Object>(bus);
	// this.tree.insertNode(nodeBus, nodeTerminal);
	// retB = true;
	// }
	// }
	// return retB;

	// }

	/**
	 * @param name
	 * @return
	 */
	// private BinaryTreeNode<Object> searchLocalidad(String name) {
	// BinaryTreeNode<Object> rNode = null;

	// if (!this.tree.isEmpty()) {
	// BinaryTreeNode<Object> aux = (BinaryTreeNode<Object>) this.tree.getRoot();
	// boolean stop = false;
	// while (!stop && aux != null) {
	// if (((Location) aux.getInfo()).getName().equalsIgnoreCase(name)) {
	// rNode = aux;
	// stop = true;
	// }
	// aux = aux.getRight();
	// }
	// }

	// return rNode;
	// }

	/**
	 * @param localidad
	 * @param ID
	 * @return
	 */
	// private BinaryTreeNode<Object> searchTerminal(String localidad, String ID) {
	// BinaryTreeNode<Object> rNode = null;

	// if (!this.tree.isEmpty()) {
	// BinaryTreeNode<Object> aux = (BinaryTreeNode<Object>) this.tree.getRoot();
	// boolean stop = false;
	// while (!stop && aux != null) {
	// if (((Location) aux.getInfo()).getName().equalsIgnoreCase(localidad)) {
	// stop = true;
	// boolean stop2 = false;
	// BinaryTreeNode<Object> aux2 = aux.getLeft();
	// while (aux2 != null && !stop2) {
	// if (((Terminal) aux2.getInfo()).getId().equalsIgnoreCase(ID)) {
	// stop2 = true;
	// rNode = aux2;
	// }
	// aux2 = aux2.getRight();
	// }

	// }
	// aux = aux.getRight();
	// }
	// }

	// return rNode;
	// }

	/**
	 * @param localidad localiad donde se encuentra el omnibus
	 * @param terminal  terminal a la cual pertenece el omnibus
	 * @param tuition   matricula del omnibus
	 * @return un objecto de tipo BinaryTreeNode que contiene el omnibus eliminado
	 */
	// private BinaryTreeNode<Object> searchBus(String localidad, String terminal,
	// String tuition) {
	// BinaryTreeNode<Object> rNode = null;

	// if (!this.tree.isEmpty()) {
	// BinaryTreeNode<Object> aux = (BinaryTreeNode<Object>) this.tree.getRoot();
	// boolean stop = false;
	// while (!stop && aux != null) {
	// if (((Location) aux.getInfo()).getName().equalsIgnoreCase(localidad)) {
	// stop = true;
	// boolean stop2 = false;
	// BinaryTreeNode<Object> aux2 = aux.getLeft();
	// while (aux2 != null && !stop2) {
	// if (((Terminal) aux2.getInfo()).getId().equalsIgnoreCase(terminal)) {
	// stop2 = true;
	// boolean stop3 = false;
	// BinaryTreeNode<Object> aux3 = aux2.getLeft();
	// while (aux3 != null && !stop3) {
	// if (((Bus) aux3.getInfo()).getTuition().equalsIgnoreCase(tuition)) {
	// stop3 = true;
	// rNode = aux3;
	// }
	// aux3 = aux3.getRight();
	// }
	// }
	// aux2 = aux2.getRight();
	// }

	// }
	// aux = aux.getRight();
	// }
	// }

	// return rNode;
	// }

	/**
	 * @param localidad localidad donde se encuantra el omnibus
	 * @param terminal  terminal a la cual pertence el omnibus
	 * @param bus       maticula del omnibus que se desea eliminar
	 * @return
	 */
	// public boolean deleteBus(String localidad, String terminal, String bus) {
	// boolean deleted = false;
	// if (!tree.isEmpty()) {
	// BinaryTreeNode<Object> nodeLocalidad = searchLocalidad(localidad);
	// if (nodeLocalidad != null) {
	// BinaryTreeNode<Object> nodeTerminal = searchTerminal(localidad, terminal);
	// if (nodeTerminal != null) {
	// BinaryTreeNode<Object> nodeBus = searchBus(localidad, terminal, bus);
	// if (nodeBus != null) {
	// tree.deleteNode(nodeBus);
	// deleted = true;
	// if (nodeTerminal.getLeft() == null) {
	// tree.deleteNode(nodeTerminal);
	// if (nodeLocalidad.getLeft() == null) {
	// BinaryTreeNode<Object> aux = (BinaryTreeNode<Object>) this.tree.getRoot();
	// boolean stop = false;
	// if (((Location) aux.getInfo()).getName()
	// .equalsIgnoreCase(((Location) nodeLocalidad.getInfo()).getName())) {
	// this.tree.setRoot(aux.getRight());
	// } else {
	// while (!stop && aux != null) {
	// if (((Location) aux.getRight().getInfo()).getName()
	// .equalsIgnoreCase(((Location) nodeLocalidad.getInfo()).getName())) {
	// aux.setRight(aux.getRight().getRight());
	// stop = true;
	// }
	// aux = aux.getRight();
	// }
	// }
	// }
	// }
	// } else {
	// throw new IllegalArgumentException("El bus que desea eliminar no existe");
	// }
	// } else {
	// throw new IllegalArgumentException("La terminal insertada no existe");
	// }
	// } else {
	// throw new IllegalArgumentException("La localidad insertada no existe");
	// }

	// } else {
	// throw new IllegalArgumentException("El árbol esta vació");
	// }

	// return deleted;
	// }

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
	public AuxClassPath shortestPath(Object a, Object b) {
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
		it.nextIndex();
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
	 * @param inicio vertice inicial de la calle donde se piensa introducir un
	 *               parada
	 * @param fin    vertice final de la calle donde se piensa introducir un parada
	 */
	public void insertStopBus(String name, double x, double y, String inicio, String fin, String matricula) {
		StopBus route = new StopBus(name, x, y);
		// Corner cUbication = new Corner(posX, posY, "yourUbication");
		// ILinkedWeightedEdgeNotDirectedGraph grapAux = map;
		Vertex v1 = findVertex(inicio);
		Vertex v2 = findVertex(fin);
		int posCorner1 = map.getVerticesList().indexOf(findVertex(inicio));
		int posCorner2 = map.getVerticesList().indexOf(findVertex(fin));
		double weight = getEdgeWeigth(v1, v2) / 2;
		map.insertVertex(route);
		int posUbication = map.getVerticesList().indexOf(findVertex(route.getId()));
		map.deleteEdgeND(posCorner2, posCorner1);
		map.insertWEdgeNDG(posCorner1, posUbication,
				new EdgeAux(weight, 0, 0, ((Corner) v1.getInfo()).getId() + "3P" + name, posCorner1, posUbication));
		map.insertWEdgeNDG(posUbication, posCorner2,
				new EdgeAux(weight, 0, 0, "P" + name + "3" + ((Corner) v2.getInfo()).getId(), posUbication,
						posCorner2));
		assignStopBus(route, matricula);
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
			aux1 = aux2;
			// aux2 = (Vertex) it.next();
		}
		return list;
	}

	public AuxClassPath findStopBusShort() {
		AuxClassPath a = new AuxClassPath();
		Iterator<Vertex> it = map.getVerticesList().iterator();
		double comp = Double.MAX_VALUE;
		AuxClassPath aux = null;
		Vertex ubication = findVertex("yourUbication");
		while (it.hasNext()) {
			Vertex v = it.next();
			if (v.getInfo() instanceof StopBus) {
				a = shortestPath(ubication, v);
				if (a.getWeigth() < comp) {
					comp = a.getWeigth();
					aux = a;
				}
			}
		}
		return aux;
	}

	public void insertUbication(double posX, double posY, String corner1,
			String corner2) {
		Corner cUbication = new Corner(posX, posY, "yourUbication");
		// ILinkedWeightedEdgeNotDirectedGraph grapAux = map;
		Vertex v1 = findVertex(corner1);
		Vertex v2 = findVertex(corner2);
		int posCorner1 = map.getVerticesList().indexOf(findVertex(corner1));
		int posCorner2 = map.getVerticesList().indexOf(findVertex(corner2));
		double weight = getEdgeWeigth(v1, v2) / 2;
		map.insertVertex(cUbication);
		int posUbication = map.getVerticesList().indexOf(findVertex(cUbication.getId()));
		map.deleteEdgeND(posCorner2, posCorner1);
		map.insertWEdgeNDG(posCorner1, posUbication,
				new EdgeAux(weight, 0, 0, ((Corner) v1.getInfo()).getId() + "3U", posCorner1, posUbication));
		map.insertWEdgeNDG(posUbication, posCorner2,
				new EdgeAux(weight, 0, 0, "U3" + ((Corner) v2.getInfo()).getId(), posUbication, posCorner2));
	}

	public void deleteUbication(String corner1, String corner2) {
		int posUbication = map.getVerticesList().indexOf(findVertex("yourUbication"));
		Vertex v1 = findVertex(corner1);
		Vertex v2 = findVertex(corner2);
		int posCorner1 = map.getVerticesList().indexOf(findVertex(corner1));
		int posCorner2 = map.getVerticesList().indexOf(findVertex(corner2));
		double weight = getEdgeWeigth(v1, v2);
		map.deleteVertex(posUbication);
		map.deleteEdgeND(posCorner1, posUbication);
		map.deleteEdgeND(posUbication, posCorner2);
		map.insertWEdgeNDG(posCorner1, posCorner2,
				new EdgeAux(weight * 2, 0, 0, corner1 + "3" + corner2, posCorner1, posCorner2));
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

	public void writeTree() {
		try (RandomAccessFile file = new RandomAccessFile(this.fileTree, "rw")) {

			LinkedList<AuxClassBusTable> list = this.getTreeInfo();
			Iterator<AuxClassBusTable> it = list.iterator();
			int totalNodes = 0;
			file.writeInt(totalNodes);

			while (it.hasNext()) {
				AuxClassBusTable node = it.next();
				byte[] byteNodeL = Convert.toBytes(node.getLocation());
				int tamNodeL = byteNodeL.length;
				file.writeInt(tamNodeL);
				file.write(byteNodeL);
				byte[] byteNodeT = Convert.toBytes(node.getTerminal());
				int tamNodeT = byteNodeT.length;
				file.writeInt(tamNodeT);
				file.write(byteNodeT);
				byte[] byteNodeB = Convert.toBytes(node.getBus());
				int tamNodeB = byteNodeB.length;
				file.writeInt(tamNodeB);
				file.write(byteNodeB);
				totalNodes++;
			}
			file.seek(0);
			file.writeInt(totalNodes);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LinkedList<AuxClassBusTable> readFileTree() {
		LinkedList<AuxClassBusTable> lista = new LinkedList<AuxClassBusTable>();
		try (
				RandomAccessFile file = new RandomAccessFile(this.fileTree, "r")) {

			int totalNodes = file.readInt();

			for (int i = 0; i < totalNodes; i++) {

				int tamInfoL = file.readInt();
				byte[] infoBytesL = new byte[tamInfoL];
				file.read(infoBytesL);
				Location infoL = (Location) Convert.toObject(infoBytesL);

				int tamInfoT = file.readInt();
				byte[] infoBytesT = new byte[tamInfoT];
				file.read(infoBytesT);
				Terminal infoT = (Terminal) Convert.toObject(infoBytesT);

				int tamInfoB = file.readInt();
				byte[] infoBytesB = new byte[tamInfoB];
				file.read(infoBytesB);
				Bus infoB = (Bus) Convert.toObject(infoBytesB);

				AuxClassBusTable n = new AuxClassBusTable(infoL, infoT, infoB, infoB.getSeating());
				lista.add(n);

			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void createTree() {
		LinkedList<AuxClassBusTable> lista = this.readFileTree();

		Iterator<AuxClassBusTable> iter = lista.iterator();
		while (iter.hasNext()) {
			AuxClassBusTable current = iter.next();
			this.insert(current.getLocation().getName(), current.getTerminal().getId(),
					current.getBus().getTuition(), current.getBus().getSeating());

		}
	}

	public void writeGraph() {

		List<Vertex> listV = this.map.getVerticesList();
		try (
				RandomAccessFile file = new RandomAccessFile(this.fileGraphVertex, "rw")) {

			int cantV = 0;
			long pos = file.getFilePointer();
			file.writeInt(cantV);

			Iterator<Vertex> iter = listV.iterator();
			while (iter.hasNext()) {
				Vertex current = iter.next();
				Corner auxCorner = null;
				StopBus auxSBus = null;

				if (current.getInfo() instanceof Corner) {
					auxCorner = (Corner) current.getInfo();
					byte[] byteVertex = Convert.toBytes(auxCorner);
					int tamVertex = byteVertex.length;
					file.writeInt(tamVertex);
					file.write(byteVertex);
					cantV++;
				} else {
					auxSBus = (StopBus) current.getInfo();
					byte[] byteVertex = Convert.toBytes(auxSBus);
					int tamVertex = byteVertex.length;
					file.writeInt(tamVertex);
					file.write(byteVertex);
					cantV++;
				}

			}
			file.seek(pos);
			file.writeInt(cantV);
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (
				RandomAccessFile file = new RandomAccessFile(this.fileGraphEdge, "rw")) {
			LinkedList<Edge> listE;
			long pos = file.getFilePointer();
			int cantE = 0;
			file.writeInt(cantE);
			Iterator<Vertex> iter = listV.iterator();
			while (iter.hasNext()) {
				Vertex current = iter.next();
				listE = current.getEdgeList();
				Iterator<Edge> iterE = listE.iterator();
				while (iterE.hasNext()) {
					WeightedEdge currentEdge = (WeightedEdge) iterE.next();
					EdgeAux a = (EdgeAux) currentEdge.getWeight();

					byte[] byteEdge = Convert.toBytes(a);
					int tamEdge = byteEdge.length;
					file.writeInt(tamEdge);
					file.write(byteEdge);
					cantE++;

				}
			}

			file.seek(pos);
			file.writeInt(cantE);
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readGraph() {

		ArrayList<Object> lista = new ArrayList<Object>();
		ArrayList<EdgeAux> listaEdge = new ArrayList<EdgeAux>();

		try (
				RandomAccessFile file = new RandomAccessFile(this.fileGraphVertex, "r")) {

			int cantV = file.readInt();

			for (int i = 0; i < cantV; i++) {

				int tamInfoV = file.readInt();
				byte[] infoBytesV = new byte[tamInfoV];
				file.read(infoBytesV);
				Object infoV = Convert.toObject(infoBytesV);

				lista.add(infoV);
			}

			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try (
				RandomAccessFile file = new RandomAccessFile(this.fileGraphEdge, "r")) {

			int cantE = file.readInt();

			for (int i = 0; i < cantE; i++) {

				int tamInfoE = file.readInt();
				byte[] infoBytesE = new byte[tamInfoE];
				file.read(infoBytesE);
				EdgeAux infoE = (EdgeAux) Convert.toObject(infoBytesE);
				listaEdge.add(infoE);
			}

			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Iterator<Object> iterC1 = lista.iterator();
		while (iterC1.hasNext()) {
			Object current = iterC1.next();
			University.getInstance().getMap().insertVertex(current);
		}
		Iterator<EdgeAux> iterE1 = listaEdge.iterator();
		while (iterE1.hasNext()) {
			EdgeAux current = iterE1.next();
			University.getInstance().getMap().insertWEdgeNDG(current.getPosCorner1(), current.getPosCorner2(), current);
		}

	}

	public void assignStopBus(StopBus stopBus, String bus) {
		Iterator<Object> iter = inDepthIterator();
		boolean stop = false;
		while (iter.hasNext() && !stop) {
			Object current = iter.next();
			// System.out.println(bus);
			if (current instanceof Bus) {
				if (((Bus) current).getTuition().equalsIgnoreCase(bus)) {
					((Bus) current).getRoute().add(stopBus);
					stop = true;
				}
			}
		}
	}

	public void deleteStopBus(String id) {

		Vertex stopBusVertex = findVertex(id);
		LinkedList<Vertex> adjacents = stopBusVertex.getAdjacents();
		int posCorner1 = map.getVerticesList().indexOf(adjacents.getFirst());
		int posCorner2 = map.getVerticesList().indexOf(adjacents.getLast());
		int posCurrent = map.getVerticesList().indexOf(stopBusVertex);
		double weight = (getEdgeWeigth(adjacents.getFirst(), stopBusVertex)) * 2;

		map.deleteEdgeND(posCorner1, posCurrent);
		map.deleteEdgeND(posCurrent, posCorner2);
		map.deleteVertex(posCurrent);
		map.insertWEdgeNDG(posCorner1, posCorner2,
				new EdgeAux(weight, 0, 0, ((Corner) adjacents.getFirst().getInfo()).getId() + "3"
						+ ((Corner) adjacents.getLast().getInfo()).getId(), posCorner1, posCorner2));
		deleteAsigment(id);
	}

	public void deleteAsigment(String id) {
		Iterator<Object> iter = inDepthIterator();
		boolean stop = false;
		while (iter.hasNext() && !stop) {
			Object current = iter.next();
			if (current instanceof Bus) {
				// if (((Bus) current).getTuition().equalsIgnoreCase(tuition)) {
				ListIterator<StopBus> it = ((Bus) current).getRoute().listIterator();
				while (it.hasNext() && !stop) {
					StopBus sb = it.next();
					if (sb.getId().equals(id)) {
						stop = true;
						it.previous();
						it.remove();
					}
				}
				// }
			}
		}
	}

	public void cargar() {

		this.readGraph();
		this.createTree();
	}

	public void guardar() {
		this.fileGraphEdge.delete();
		this.fileGraphVertex.delete();
		this.fileTree.delete();
		this.writeGraph();
		this.writeTree();
	}

	// Nuevo
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
			BinaryTreeNode<Object> nodeBus = new BinaryTreeNode<Object>(bus);
			this.tree.insertNode(nodeBus, nodeTerminal);
			// update(bus); // Actualizar

			retB = true;
		} else {
			BinaryTreeNode<Object> nodeLocation2 = searchLocalidad(Location);
			if (nodeLocation2 != null) {
				BinaryTreeNode<Object> nodeTerminal2 = searchTerminal(nodeLocation2, Terminal);
				if (nodeTerminal2 != null) {
					BinaryTreeNode<Object> nodeBus2 = searchBus(nodeTerminal2, Bus);
					if (nodeBus2 != null) {
						throw new IllegalArgumentException("El bus ya existe");
					} else {
						Bus bus = new Bus(Bus, seating);
						BinaryTreeNode<Object> nodeBusAux = new BinaryTreeNode<Object>(bus);
						this.tree.insertNode(nodeBusAux, nodeTerminal2);
						// update(bus); // Actualizar
						retB = true;
					}
				} else {
					Terminal terminal = new Terminal(Terminal);
					BinaryTreeNode<Object> nodeTerminal4 = new BinaryTreeNode<Object>(terminal);
					this.tree.insertNode(nodeTerminal4, nodeLocation2);
					Bus bus = new Bus(Bus, seating);
					BinaryTreeNode<Object> nodeBus4 = new BinaryTreeNode<Object>(bus);
					this.tree.insertNode(nodeBus4, nodeTerminal4);
					// update(bus); // Actualizar
					retB = true;
				}
			} else {
				Location location = new Location(Location);
				BinaryTreeNode<Object> nodeLocation3 = new BinaryTreeNode<Object>(location);
				this.tree.insertNode(nodeLocation3, null);

				Terminal terminal = new Terminal(Terminal);
				BinaryTreeNode<Object> nodeTerminal3 = new BinaryTreeNode<Object>(terminal);
				this.tree.insertNode(nodeTerminal3, nodeLocation3);

				Bus bus = new Bus(Bus, seating);
				bus.setSeating(seating);
				BinaryTreeNode<Object> nodeBus3 = new BinaryTreeNode<Object>(bus);
				this.tree.insertNode(nodeBus3, nodeTerminal3);
				// update(bus); // Actualizar
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

	private BinaryTreeNode<Object> searchTerminal(BinaryTreeNode<Object> localidad, String terminal) {
		BinaryTreeNode<Object> rNode = null;
		if (!this.tree.isEmpty()) {
			if (localidad.getLeft() != null) {
				BinaryTreeNode<Object> aux = localidad.getLeft();
				boolean stop = false;
				while (!stop) {
					if (((Terminal) aux.getInfo()).getId().equalsIgnoreCase(terminal)) {
						stop = true;
						rNode = aux;
					}
					if (aux.getRight() != null) {
						aux = aux.getRight();
					} else
						stop = true;
				}
			}
		}
		return rNode;
	}

	private BinaryTreeNode<Object> searchBus(BinaryTreeNode<Object> terminal, String tuition) {
		BinaryTreeNode<Object> rNode = null;
		if (!this.tree.isEmpty()) {
			if (terminal.getLeft() != null) {
				BinaryTreeNode<Object> aux = terminal.getLeft();
				boolean stop = false;
				while (!stop) {
					if (((Bus) aux.getInfo()).getTuition().equalsIgnoreCase(tuition)) {
						stop = true;
						rNode = aux;
					}
					if (aux.getRight() != null) {
						aux = aux.getRight();
					} else
						stop = true;
				}
			}
		}
		return rNode;
	}

	public boolean deleteBus(String localidad, String terminal, String bus) {
		boolean deleted = false;
		if (!tree.isEmpty()) {
			BinaryTreeNode<Object> nodeLocalidad = searchLocalidad(localidad);
			if (nodeLocalidad != null) {
				BinaryTreeNode<Object> nodeTerminal = searchTerminal(nodeLocalidad, terminal);
				if (nodeTerminal != null) {
					BinaryTreeNode<Object> nodeBus = searchBus(nodeTerminal, bus);
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
			throw new IllegalArgumentException("El Ã¡rbol esta vaciÃ³");
		}

		return deleted;
	}

	public boolean changeBus(String Location, String Terminal, String Bus, int seating) {
		boolean value = false;
		BinaryTreeNode<Object> nodeLocation = searchLocalidad(Location);
		if (nodeLocation != null) {
			BinaryTreeNode<Object> nodeTerminal = searchTerminal(nodeLocation, Terminal);
			if (nodeTerminal != null) {
				BinaryTreeNode<Object> nodeBus = searchBus(nodeTerminal, Bus);
				if (nodeBus != null) {
					((Bus) nodeBus.getInfo()).setSeating(seating);
					value = true;
					// update((Bus)nodeBus.getInfo()); // Actualizar
				}
			}
		}
		return value;
	}

}