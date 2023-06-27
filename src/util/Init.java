package util;

import Logic.Corner;
import Logic.University;
import cu.edu.cujae.ceis.graph.edge.Edge;

public class Init {

    public static void data() {

        University.getInstance().insertBus("L1", "T1", "b1", 1);
        University.getInstance().insertBus("L1", "T2", "b2", 43);
        University.getInstance().insertBus("L2", "T3", "b3", 780);
        University.getInstance().insertBus("L3", "T4", "b4", 123);
        University.getInstance().insertBus("L3", "T5", "b5", 132);

        Corner a = new Corner(513, -324, "A");
        Corner b = new Corner(172.5, -324, "B");
        Corner c = new Corner(131, -97, "C");
        Corner d = new Corner(119, 109.5, "D");
        Corner e = new Corner(-219.5, 109.5, "E");
        Corner f = new Corner(-296, 41.5, "F");
        Corner g = new Corner(41.5, 346, "G");
        Corner h = new Corner(-208, 346, "H");

        University.getInstance().getMap().insertVertex(a);
        University.getInstance().getMap().insertVertex(b);
        University.getInstance().getMap().insertVertex(c);
        University.getInstance().getMap().insertVertex(d);
        University.getInstance().getMap().insertVertex(e);
        University.getInstance().getMap().insertVertex(f);
        University.getInstance().getMap().insertVertex(g);
        University.getInstance().getMap().insertVertex(h);

        University.getInstance().getMap().insertWEdgeNDG(0, 1, 1.0);
        University.getInstance().getMap().insertWEdgeNDG(1, 2, 3.0);
        University.getInstance().getMap().insertWEdgeNDG(0, 3, 5.0);
        University.getInstance().getMap().insertWEdgeNDG(1, 4, 2.0);
        University.getInstance().getMap().insertWEdgeNDG(3, 4, 3.0);
        University.getInstance().getMap().insertWEdgeNDG(4, 5, 3.0);
        University.getInstance().getMap().insertWEdgeNDG(2, 5, 5.0);
        University.getInstance().getMap().insertWEdgeNDG(3, 6, 8.0);
        University.getInstance().getMap().insertWEdgeNDG(6, 7, 9.0);
        University.getInstance().getMap().insertWEdgeNDG(4, 7, 1.0);

    }

    public static void datosReales() {

        Corner a001 = new Corner(760, 588, "258/Carretera del Wajay(243)");
        Corner a002 = new Corner(862, 694, "258/269");
        University.getInstance().getMap().insertVertex(a001);
        University.getInstance().getMap().insertVertex(a002);
        University.getInstance().getMap().insertWEdgeNDG(0, 1, new EdgeAux(0.208, 661, 587));

        Corner a003 = new Corner(955, 792, "258/283");
        University.getInstance().getMap().insertVertex(a003);
        University.getInstance().getMap().insertWEdgeNDG(1, 2, new EdgeAux(0.205, 763, 694));

        Corner a004 = new Corner(714, 619, "260/Carretera del Wajay(243)");
        University.getInstance().getMap().insertVertex(a004);
        University.getInstance().getMap().insertWEdgeNDG(0, 3, new EdgeAux(0.042, 660, 587));

        Corner a005 = new Corner(816, 723, "260/269");
        University.getInstance().getMap().insertVertex(a005);
        University.getInstance().getMap().insertWEdgeNDG(1, 4, new EdgeAux(0.041, 761, 694));

        Corner a006 = new Corner(909, 821, "260/283");
        University.getInstance().getMap().insertVertex(a006);
        University.getInstance().getMap().insertWEdgeNDG(2, 5, new EdgeAux(0.045, 855, 792));

        University.getInstance().getMap().insertWEdgeNDG(3, 4, new EdgeAux(0.205, 612, 617));

        University.getInstance().getMap().insertWEdgeNDG(4, 5, new EdgeAux(0.184, 714, 722));

        Corner a007 = new Corner(667, 648, "262/Carretera del Wajay(243)");
        University.getInstance().getMap().insertVertex(a007);
        University.getInstance().getMap().insertWEdgeNDG(3, 6, new EdgeAux(0.044, 612, 619));

        Corner a008 = new Corner(769, 753, "262/269");
        University.getInstance().getMap().insertVertex(a008);
        University.getInstance().getMap().insertWEdgeNDG(7, 4, new EdgeAux(0.039, 714, 724));

        Corner a009 = new Corner(862, 853, "262/283");
        University.getInstance().getMap().insertVertex(a009);
        University.getInstance().getMap().insertWEdgeNDG(5, 8, new EdgeAux(0.043, 807, 824));

        University.getInstance().getMap().insertWEdgeNDG(6, 7, new EdgeAux(0.198, 567, 646));

        University.getInstance().getMap().insertWEdgeNDG(7, 8, new EdgeAux(0.171, 668, 753));
    }

}
