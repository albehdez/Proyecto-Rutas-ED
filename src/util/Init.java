package util;

import Logic.Corner;
import Logic.University;
import cu.edu.cujae.ceis.graph.edge.Edge;

public class Init {

    public static void data() {

        University.getInstance().insertBus("Boyeros", "Santiago de la Vegas", "B753268", 17);
        University.getInstance().insertBus("Arroyo Naranjo", "Poey", "B783229", 19);
        University.getInstance().insertBus("Diez de Octubre", "Lawton", "B355270", 15);
        University.getInstance().insertBus("Playa", "Nautico", "B759849", 25);
        University.getInstance().insertBus("Boyeros", "Santiago de la Vegas", "B787356", 20);

        Corner a = new Corner(97, 127, "A");
        Corner b = new Corner(271, 130, "B");
        Corner c = new Corner(393, 130, "C");
        Corner d = new Corner(511, 130, "D");
        Corner e = new Corner(658, 132, "E");
        Corner f = new Corner(104, 270, "F");
        Corner g = new Corner(271, 270, "G");
        Corner h = new Corner(393, 269, "H");
        Corner i = new Corner(511, 269, "I");
        Corner j = new Corner(657, 270, "J");
        Corner k = new Corner(103, 368, "K");
        Corner l = new Corner(192, 354, "L");
        Corner m = new Corner(386, 353, "M");
        Corner n = new Corner(512, 353, "N");
        Corner ñ = new Corner(308, 411, "Ñ");
        Corner o = new Corner(104, 458, "O");
        Corner p = new Corner(251, 458, "P");
        Corner q = new Corner(401, 458, "Q");
        Corner r = new Corner(512, 459, "R");
        Corner s = new Corner(571, 458, "S");
        Corner t = new Corner(103, 597, "T");
        Corner u = new Corner(251, 596, "U");
        Corner v = new Corner(401, 596, "V");
        // Corner w = new Corner(703, 130, "W");
        // Corner x = new Corner(512, 353, "X");

        University.getInstance().getMap().insertVertex(a);
        University.getInstance().getMap().insertVertex(b);
        University.getInstance().getMap().insertVertex(c);
        University.getInstance().getMap().insertVertex(d);
        University.getInstance().getMap().insertVertex(e);
        University.getInstance().getMap().insertVertex(f);
        University.getInstance().getMap().insertVertex(g);
        University.getInstance().getMap().insertVertex(h);
        University.getInstance().getMap().insertVertex(i);
        University.getInstance().getMap().insertVertex(j);
        University.getInstance().getMap().insertVertex(k);
        University.getInstance().getMap().insertVertex(l);
        University.getInstance().getMap().insertVertex(m);
        University.getInstance().getMap().insertVertex(n);
        University.getInstance().getMap().insertVertex(ñ);
        University.getInstance().getMap().insertVertex(o);
        University.getInstance().getMap().insertVertex(p);
        University.getInstance().getMap().insertVertex(q);
        University.getInstance().getMap().insertVertex(r);
        University.getInstance().getMap().insertVertex(s);
        University.getInstance().getMap().insertVertex(t);
        University.getInstance().getMap().insertVertex(u);
        University.getInstance().getMap().insertVertex(v);

        // centro
        // University.getInstance().getMap().insertVertex();
        // University.getInstance().getMap().insertVertex();

        // Ala este

        // Ala oeste
        // horizontales
        University.getInstance().getMap().insertWEdgeNDG(0, 1, new EdgeAux(0.208, 514, 544, "A-B"));
        University.getInstance().getMap().insertWEdgeNDG(1, 2, new EdgeAux(0.045, 633, 544, "B-C"));
        University.getInstance().getMap().insertWEdgeNDG(2, 3, new EdgeAux(0.045, 753, 544, "C-D"));
        University.getInstance().getMap().insertWEdgeNDG(5, 6, new EdgeAux(0.208, 511, 685, "F-G"));
        University.getInstance().getMap().insertWEdgeNDG(6, 7, new EdgeAux(0.045, 633, 685, "G-H"));
        University.getInstance().getMap().insertWEdgeNDG(7, 8, new EdgeAux(0.045, 753, 685, "H-I"));
        University.getInstance().getMap().insertWEdgeNDG(8, 9, new EdgeAux(0.184, 820, 606, "I-J"));
        University.getInstance().getMap().insertWEdgeNDG(10, 11, new EdgeAux(0.064, 408, 261, "K-L"));
        University.getInstance().getMap().insertWEdgeNDG(12, 13, new EdgeAux(0.049, 590, 333, "M-N"));
        University.getInstance().getMap().insertWEdgeNDG(15, 16, new EdgeAux(0.126, 751, 874, "O-P"));
        University.getInstance().getMap().insertWEdgeNDG(16, 17, new EdgeAux(0.126, 899, 874, "P-Q"));
        University.getInstance().getMap().insertWEdgeNDG(17, 18, new EdgeAux(0.126, 812, 874, "Q-R"));
        University.getInstance().getMap().insertWEdgeNDG(18, 19, new EdgeAux(0.05, 812, 874, "R-S"));
        // verticales
        University.getInstance().getMap().insertWEdgeNDG(3, 8, new EdgeAux(0.184, 753, 545, "D-I"));
        University.getInstance().getMap().insertWEdgeNDG(2, 7, new EdgeAux(0.184, 634, 544, "C-H"));
        University.getInstance().getMap().insertWEdgeNDG(1, 6, new EdgeAux(0.184, 512, 544, "B-G"));
        University.getInstance().getMap().insertWEdgeNDG(4, 9, new EdgeAux(0.184, 815, 571, "E-J"));
        University.getInstance().getMap().insertWEdgeNDG(5, 10, new EdgeAux(0.135, 344, 732, "F-K"));
        University.getInstance().getMap().insertWEdgeNDG(10, 15, new EdgeAux(0.135, 344, 823, "K-O"));
        University.getInstance().getMap().insertWEdgeNDG(8, 13, new EdgeAux(0.086, 772, 735, "I-N"));
        University.getInstance().getMap().insertWEdgeNDG(13, 18, new EdgeAux(0.184, 772, 820, "N-R"));
        University.getInstance().getMap().insertWEdgeNDG(6, 11, new EdgeAux(0.066, 398, 250, "G-L"));
        University.getInstance().getMap().insertWEdgeNDG(12, 14, new EdgeAux(0.053, 382, 377, "M-Ñ"));
        University.getInstance().getMap().insertWEdgeNDG(14, 16, new EdgeAux(0.053, 392, 388, "Ñ-P"));
        University.getInstance().getMap().insertWEdgeNDG(15, 20, new EdgeAux(0.131, 344, 874, "O-T"));
        University.getInstance().getMap().insertWEdgeNDG(16, 21, new EdgeAux(0.131, 492, 874, "P-U"));
        University.getInstance().getMap().insertWEdgeNDG(17, 22, new EdgeAux(0.131, 642, 874, "Q-V"));
        University.getInstance().getMap().insertWEdgeNDG(9, 19, new EdgeAux(0.290, 729, 760, "J-S"));

        // Ala centro
        Corner a2 = new Corner(678, 345, "A2");
        Corner b2 = new Corner(725, 421, "B2");
        Corner c2 = new Corner(618, 478, "C2");
        Corner d2 = new Corner(764, 485, "D2");
        Corner e2 = new Corner(580, 570, "E2");
        Corner f2 = new Corner(810, 570, "F2");

        University.getInstance().getMap().insertVertex(a2);
        University.getInstance().getMap().insertVertex(b2);
        University.getInstance().getMap().insertVertex(c2);
        University.getInstance().getMap().insertVertex(d2);
        University.getInstance().getMap().insertVertex(e2);
        University.getInstance().getMap().insertVertex(f2);

        University.getInstance().getMap().insertWEdgeNDG(19, 25, new EdgeAux(0.290, 529, 487, "S-C2"));
        University.getInstance().getMap().insertWEdgeNDG(25, 23, new EdgeAux(0.290, 412, 215, "C2-A2"));
        University.getInstance().getMap().insertWEdgeNDG(23, 24, new EdgeAux(0.290, 723, 336, "A2-B2"));
        University.getInstance().getMap().insertWEdgeNDG(24, 26, new EdgeAux(0.290, 747, 202, "B2-D2"));
        University.getInstance().getMap().insertWEdgeNDG(26, 28, new EdgeAux(0.290, 1231, 755, "D2-F2"));
        University.getInstance().getMap().insertWEdgeNDG(28, 27, new EdgeAux(0.290, 489, 428, "F2-E2"));
        University.getInstance().getMap().insertWEdgeNDG(27, 25, new EdgeAux(0.290, 599, 385, "E2-C2"));
        University.getInstance().getMap().insertWEdgeNDG(25, 26, new EdgeAux(0.290, 929, 458, "C2-D2"));
    }

    // public static void datosReales() {

    // Corner a001 = new Corner(760, 588, "258/Carretera del Wajay(243)");
    // Corner a002 = new Corner(862, 694, "258/269");
    // University.getInstance().getMap().insertVertex(a001);
    // University.getInstance().getMap().insertVertex(a002);
    // University.getInstance().getMap().insertWEdgeNDG(0, 1, new EdgeAux(0.208,
    // 661, 587,
    // "258/Carretera del Wajay(243)-258/269"));

    // Corner a003 = new Corner(955, 792, "258/283");
    // University.getInstance().getMap().insertVertex(a003);
    // University.getInstance().getMap().insertWEdgeNDG(1, 2, new EdgeAux(0.205,
    // 763, 694, "258/269-258/283"));

    // Corner a004 = new Corner(714, 619, "260/Carretera del Wajay(243)");
    // University.getInstance().getMap().insertVertex(a004);
    // University.getInstance().getMap().insertWEdgeNDG(0, 3, new EdgeAux(0.042,
    // 660, 587,"258/Carretera del Wajay(243)-260/Carretera del Wajay(243)"));

    // Corner a005 = new Corner(816, 723, "260/269");
    // University.getInstance().getMap().insertVertex(a005);
    // University.getInstance().getMap().insertWEdgeNDG(1, 4, new EdgeAux(0.041,
    // 761, 694,"258/269-260/269"));

    // Corner a006 = new Corner(909, 821, "260/283");
    // University.getInstance().getMap().insertVertex(a006);
    // University.getInstance().getMap().insertWEdgeNDG(2, 5, new EdgeAux(0.045,
    // 855, 792,"258/283-260/283"));

    // University.getInstance().getMap().insertWEdgeNDG(3, 4, new EdgeAux(0.205,
    // 612, 617,));

    // University.getInstance().getMap().insertWEdgeNDG(4, 5, new EdgeAux(0.184,
    // 714, 722));

    // Corner a007 = new Corner(667, 648, "262/Carretera del Wajay(243)");
    // University.getInstance().getMap().insertVertex(a007);
    // University.getInstance().getMap().insertWEdgeNDG(3, 6, new EdgeAux(0.044,
    // 612, 619));

    // Corner a008 = new Corner(769, 753, "262/269");
    // University.getInstance().getMap().insertVertex(a008);
    // University.getInstance().getMap().insertWEdgeNDG(7, 4, new EdgeAux(0.039,
    // 714, 724));

    // Corner a009 = new Corner(862, 853, "262/283");
    // University.getInstance().getMap().insertVertex(a009);
    // University.getInstance().getMap().insertWEdgeNDG(5, 8, new EdgeAux(0.043,
    // 807, 824));

    // University.getInstance().getMap().insertWEdgeNDG(6, 7, new EdgeAux(0.198,
    // 567, 646));

    // University.getInstance().getMap().insertWEdgeNDG(7, 8, new EdgeAux(0.171,
    // 668, 753));
    // }

}
