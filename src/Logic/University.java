package Logic;

import java.util.LinkedList;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import util.AuxC4Table;

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
}