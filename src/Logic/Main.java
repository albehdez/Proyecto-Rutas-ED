package Logic;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		University.getInstance().insert("L1", "T1", "b1", 1);
		University.getInstance().insert("L1", "T2", "b2", 43);
		University.getInstance().insert("L2", "T3", "b3", 780);
		University.getInstance().insert("L3", "T4", "b4", 123);
		University.getInstance().insert("L3", "T5", "b5", 132);

		// Iterator<Object> it = University.getInstance().getTree().inDepthIterator();

		// while (it.hasNext()) {
		// Object nod = it.next();
		// if (nod instanceof Terminal)
		// System.out.println(((Terminal) nod).getId());
		// else if (nod instanceof LocationT)
		// System.out.println(((LocationT) nod).getName());
		// else
		// System.out.println(((Bus) nod).getTuition());
		// }

		// University.getInstance().deleteBus("L1", "T1", "b1");
		// University.getInstance().deleteBus("L1", "T2", "b2");
		// System.out.println();

		// it = University.getInstance().getTree().inDepthIterator();

		// while (it.hasNext()) {
		// Object nod = it.next();
		// if (nod instanceof Terminal)
		// System.out.println(((Terminal) nod).getId());
		// else if (nod instanceof LocationT)
		// System.out.println(((LocationT) nod).getName());
		// else
		// System.out.println(((Bus) nod).getTuition());

		// }

		University.getInstance().getMap().insertVertex("D");
		University.getInstance().getMap().insertVertex(3);

	}
}