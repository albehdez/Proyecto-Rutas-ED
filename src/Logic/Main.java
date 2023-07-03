package Logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import util.AuxClassBusTable;
import util.AuxClassPath;

import util.Init;

public class Main {

	public static void main(String[] args) {

		// University.getInstance().insert("L1", "T1", "b1", 1);
		// University.getInstance().insert("L1", "T2", "b2", 43);
		// University.getInstance().insert("L2", "T3", "b3", 780);
		// University.getInstance().insert("L3", "T4", "b4", 123);
		// University.getInstance().insert("L3", "T5", "b5", 132);

		// LinkedList<AuxC4Table> list = University.getInstance().getNodesInfo();
		// System.out.println(list);
		// Iterator<AuxC4Table> it = list.iterator();
		// while (it.hasNext()) {
		// AuxC4Table a = it.next();
		// System.out.println(
		// a.getLocation().getName() + ", " + a.getTerminal().getId() + "," +
		// a.getBus().getTuition() + ", "
		// + a.getBus().getSeating());
		// }
		// University.getInstance().deleteBus("L1", "T1", "b1");
		// University.getInstance().deleteBus("L1", "T2", "b2");
		// University.getInstance().deleteBus("L2", "T3", "b3");
		// University.getInstance().deleteBus("L3", "T4", "b4");
		// University.getInstance().deleteBus("L3", "T5", "b5");

		

		// University.getInstance().deleteBus("L3", "T5", "b5");
		// University.getInstance().deleteBus("L3", "T4", "b4");

		// System.out.println();

		// it = University.getInstance().getTree().inDepthIterator();

		// while (it.hasNext()) {
		// Object nod = it.next();
		// if (nod instanceof Terminal)
		// System.out.println(((Terminal) nod).getId());
		// else if (nod instanceof Location)
		// System.out.println(((Location) nod).getName());
		// else
		// System.out.println(((Bus) nod).getTuition());
		// }

		// University.getInstance().getMap().insertVertex("D");
		// University.getInstance().getMap().insertVertex(3);
		Init.data();
		University.getInstance().setFile(new File("D:/Fichero.txt"));
		//University.getInstance().writeTree();
		University.getInstance().createTree();
		GeneralTree<Object> u= University.getInstance().getTree();
		Iterator<Object> it = University.getInstance().getTree().inDepthIterator();

		while (it.hasNext()) {
		Object nod = it.next();
		if (nod instanceof Terminal)
		System.out.println(((Terminal) nod).getId());
		else if (nod instanceof Location)
		System.out.println(((Location) nod).getName());
		else
		System.out.println(((Bus) nod).getTuition());
		}
		// University.getInstance().writeTree();
  		
		
		// Conner a = new Conner(513, -324, "A");
		// Conner h = new Conner(-208, 346, "H");
		// University.getInstance().getMap().insertVertex("A");
		// University.getInstance().getMap().insertVertex("B");
		// University.getInstance().getMap().insertVertex("C");
		// University.getInstance().getMap().insertWEdgeNDG(0, 1, 1.0);
		// University.getInstance().getMap().insertWEdgeNDG(1, 2, 6.0);
		// University.getInstance().getMap().insertWEdgeNDG(0, 2, 1.0);

		AuxClassPath aux = University.getInstance().shortestPath(
				University.getInstance().getMap().getVerticesList().get(0),
				University.getInstance().getMap().getVerticesList().get(6), University.getInstance().getMap());
		Iterator<Object> iter = aux.getList().iterator();
		System.out.println("Peso: " + aux.getWeigth());
		while (iter.hasNext()) {
			Vertex o = (Vertex) iter.next();
			System.out.println(((Corner) o.getInfo()).getId());
		}
	}
}
