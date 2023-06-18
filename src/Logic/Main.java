package Logic;

import java.util.Iterator;
import java.util.LinkedList;

import util.AuxC4Table;

public class Main {

	public static void main(String[] args) {
		
		University.getInstance().insert("L1", "T1", "b1", 1);
		University.getInstance().insert("L1", "T2", "b2", 43);
		University.getInstance().insert("L2", "T3", "b3", 780);
		University.getInstance().insert("L3", "T4", "b4", 123);
		University.getInstance().insert("L3", "T5", "b5", 132);
		
		LinkedList<AuxC4Table> list = University.getInstance().getNodesInfo();
		//University.getInstance().deleteBus("L1", "T1", "b1");	
		//University.getInstance().deleteBus("L1", "T2", "b2");
		//University.getInstance().deleteBus("L2", "T3", "b3");
		//University.getInstance().deleteBus("L3", "T4", "b4");
		//University.getInstance().deleteBus("L3", "T5", "b5");

		Iterator<Object> it = University.getInstance().getTree().inDepthIterator();

		while (it.hasNext()) {
			Object nod = it.next();
			if (nod instanceof Terminal)
				System.out.println(((Terminal) nod).getId());
			else if (nod instanceof LocationT)
				System.out.println(((LocationT) nod).getName());
			else
				System.out.println(((Bus) nod).getTuition());
		}

		// University.getInstance().deleteBus("L3", "T4", "b4");
		// University.getInstance().deleteBus("L3", "T5", "b5");
		System.out.println();

		Iterator<Object> it1 = University.getInstance().getTree().inDepthIterator();

		while (it1.hasNext()) {
			Object nod = it1.next();
			if (nod instanceof Terminal)
				System.out.println(((Terminal) nod).getId());
			else if (nod instanceof LocationT)
				System.out.println(((LocationT) nod).getName());
			else
				System.out.println(((Bus) nod).getTuition());
		}
		// University.getInstance().getMap().insertVertex("A");
		// University.getInstance().getMap().insertVertex("B");
		// University.getInstance().getMap().insertVertex("C");

		// University.getInstance().getMap().insertEdgeNDG(0, 1);
		// University.getInstance().getMap().insertEdgeNDG(1, 2);
		// University.getInstance().getMap().insertEdgeNDG(0, 2);

		// University.getInstance().getMap().insertWEdgeNDG(0, 1, 1);
		// University.getInstance().getMap().insertWEdgeNDG(1, 2, 67);
		// University.getInstance().getMap().insertWEdgeNDG(0, 2, 10);
	}
}
