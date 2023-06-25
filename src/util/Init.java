package util;

import Logic.Conner;
import Logic.University;

public class Init {

    public static void data() {

        University.getInstance().insert("L1", "T1", "b1", 1);
        University.getInstance().insert("L1", "T2", "b2", 43);
        University.getInstance().insert("L2", "T3", "b3", 780);
        University.getInstance().insert("L3", "T4", "b4", 123);
        University.getInstance().insert("L3", "T5", "b5", 132);

        Conner a = new Conner(513, -324, "A");
        Conner b = new Conner(172.5, -324, "B");
        Conner c = new Conner(131, -97, "C");
        Conner d = new Conner(119, 109.5, "D");
        Conner e = new Conner(-219.5, 109.5, "E");
        Conner f = new Conner(-296, 41.5, "F");
        Conner g = new Conner(41.5, 346, "G");
        Conner h = new Conner(-208, 346, "H");

        University.getInstance().getMap().insertVertex(a);
        University.getInstance().getMap().insertVertex(b);
        University.getInstance().getMap().insertVertex(c);
        University.getInstance().getMap().insertVertex(d);
        University.getInstance().getMap().insertVertex(e);
        University.getInstance().getMap().insertVertex(f);
        University.getInstance().getMap().insertVertex(g);
        University.getInstance().getMap().insertVertex(h);

        University.getInstance().getMap().insertWEdgeNDG(0, 1, 1);
        University.getInstance().getMap().insertWEdgeNDG(1, 2, 3);
        University.getInstance().getMap().insertWEdgeNDG(0, 3, 5);
        University.getInstance().getMap().insertWEdgeNDG(0, 4, 2);
        University.getInstance().getMap().insertWEdgeNDG(3, 4, 3);
        University.getInstance().getMap().insertWEdgeNDG(4, 5, 3);
        University.getInstance().getMap().insertWEdgeNDG(2, 5, 5);
        University.getInstance().getMap().insertWEdgeNDG(3, 6, 8);
        University.getInstance().getMap().insertWEdgeNDG(6, 7, 9);
        University.getInstance().getMap().insertWEdgeNDG(4, 7, 1);

    }

}
