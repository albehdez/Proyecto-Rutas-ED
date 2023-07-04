package util;

import Logic.Corner;
import Logic.StopBus;
import Logic.University;
import cu.edu.cujae.ceis.graph.edge.Edge;

public class Init {

    public static void data() {

        University.getInstance().insertBus("Boyeros", "Santiago de la Vegas", "B753268", 17);
        University.getInstance().insertBus("Arroyo Naranjo", "Santa Amalia", "B783229", 19);

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

        // Ala oeste
        // horizontales
        University.getInstance().getMap().insertWEdgeNDG(0, 1, new EdgeAux(0.208, 514, 544, "A3B", 0, 1));
        University.getInstance().getMap().insertWEdgeNDG(1, 2, new EdgeAux(0.045, 633, 544, "B3C", 1, 2));
        University.getInstance().getMap().insertWEdgeNDG(2, 3, new EdgeAux(0.045, 753, 544, "C3D", 2, 3));
        University.getInstance().getMap().insertWEdgeNDG(5, 6, new EdgeAux(0.208, 511, 685, "F3G", 5, 6));
        University.getInstance().getMap().insertWEdgeNDG(6, 7, new EdgeAux(0.045, 633, 685, "G3H", 6, 7));
        University.getInstance().getMap().insertWEdgeNDG(7, 8, new EdgeAux(0.045, 753, 685, "H3I", 7, 8));
        University.getInstance().getMap().insertWEdgeNDG(8, 9, new EdgeAux(0.184, 820, 606, "I3J", 8, 9));
        University.getInstance().getMap().insertWEdgeNDG(10, 11, new EdgeAux(0.064, 408, 261, "K3L", 10, 11));
        University.getInstance().getMap().insertWEdgeNDG(12, 13, new EdgeAux(0.049, 590, 333, "M3N", 12, 13));
        University.getInstance().getMap().insertWEdgeNDG(15, 16, new EdgeAux(0.526, 751, 874, "O3P", 15, 16));
        University.getInstance().getMap().insertWEdgeNDG(16, 17, new EdgeAux(0.126, 899, 874, "P3Q", 16, 17));
        University.getInstance().getMap().insertWEdgeNDG(17, 18, new EdgeAux(0.126, 812, 874, "Q3R", 17, 18));
        University.getInstance().getMap().insertWEdgeNDG(18, 19, new EdgeAux(0.05, 812, 874, "R3S", 18, 19));
        // verticales
        University.getInstance().getMap().insertWEdgeNDG(3, 8, new EdgeAux(0.184, 753, 545, "D3I", 3, 8));
        University.getInstance().getMap().insertWEdgeNDG(2, 7, new EdgeAux(0.184, 634, 544, "C3H", 2, 7));
        University.getInstance().getMap().insertWEdgeNDG(1, 6, new EdgeAux(0.184, 512, 544, "B3G", 1, 6));
        University.getInstance().getMap().insertWEdgeNDG(4, 9, new EdgeAux(0.184, 815, 571, "E3J", 4, 9));
        University.getInstance().getMap().insertWEdgeNDG(5, 10, new EdgeAux(0.135, 344, 732, "F3K", 5, 10));
        University.getInstance().getMap().insertWEdgeNDG(10, 15, new EdgeAux(0.135, 344, 823, "K3O", 10, 15));
        University.getInstance().getMap().insertWEdgeNDG(8, 13, new EdgeAux(0.086, 772, 735, "I3N", 8, 13));
        University.getInstance().getMap().insertWEdgeNDG(13, 18, new EdgeAux(0.184, 772, 820, "N3R", 13, 18));
        University.getInstance().getMap().insertWEdgeNDG(6, 11, new EdgeAux(0.066, 398, 250, "G3L", 6, 11));
        University.getInstance().getMap().insertWEdgeNDG(11, 14, new EdgeAux(0.053, 408, 261, "L3Ñ", 11, 14));
        University.getInstance().getMap().insertWEdgeNDG(12, 14, new EdgeAux(0.053, 382, 377, "M3Ñ", 12, 14));
        University.getInstance().getMap().insertWEdgeNDG(14, 16, new EdgeAux(0.053, 392, 388, "Ñ3P", 14, 16));
        University.getInstance().getMap().insertWEdgeNDG(15, 20, new EdgeAux(0.131, 344, 874, "O3T", 15, 20));
        University.getInstance().getMap().insertWEdgeNDG(16, 21, new EdgeAux(0.131, 492, 874, "P3U", 16, 21));
        University.getInstance().getMap().insertWEdgeNDG(17, 22, new EdgeAux(0.131, 642, 874, "Q3V", 17, 22));
        University.getInstance().getMap().insertWEdgeNDG(9, 19, new EdgeAux(0.290, 729, 760, "J3S", 9, 19));

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

        University.getInstance().getMap().insertWEdgeNDG(19, 25, new EdgeAux(0.290, 529, 487, "S3C2", 19, 25));
        University.getInstance().getMap().insertWEdgeNDG(25, 23, new EdgeAux(0.290, 412, 215, "C23A2", 25, 23));
        University.getInstance().getMap().insertWEdgeNDG(23, 24, new EdgeAux(0.290, 723, 336, "A23B2", 23, 24));
        University.getInstance().getMap().insertWEdgeNDG(24, 26, new EdgeAux(0.290, 747, 202, "B23D2", 24, 26));
        University.getInstance().getMap().insertWEdgeNDG(26, 28, new EdgeAux(0.290, 1231, 755, "D23F2", 26, 28));
        University.getInstance().getMap().insertWEdgeNDG(28, 27, new EdgeAux(0.590, 489, 428, "F23E2", 28, 27));
        University.getInstance().getMap().insertWEdgeNDG(27, 25, new EdgeAux(0.290, 599, 385, "E23C2", 27, 25));
        University.getInstance().getMap().insertWEdgeNDG(25, 26, new EdgeAux(0.290, 929, 458, "C23D2", 25, 26));

        // Ala este
        Corner a1 = new Corner(703, 130, "A1");
        Corner b1 = new Corner(847, 130, "B1");
        Corner c1 = new Corner(1020, 130, "C1");
        Corner d1 = new Corner(1145, 130, "D1");
        Corner e1 = new Corner(1267, 130, "E1");
        Corner f1 = new Corner(703, 296, "F1");
        Corner g1 = new Corner(853, 289, "G1");
        Corner h1 = new Corner(1020, 284, "H1");
        Corner i1 = new Corner(1268, 289, "I1");
        Corner j1 = new Corner(1021, 349, "J1");
        Corner k1 = new Corner(1143, 350, "K1");
        Corner l1 = new Corner(769, 396, "L1");
        Corner m1 = new Corner(869, 426, "M1");
        Corner n1 = new Corner(1020, 432, "N1");
        Corner ñ1 = new Corner(1114, 432, "Ñ1");
        Corner o1 = new Corner(1268, 434, "O1");
        Corner p1 = new Corner(884, 579, "P1");
        Corner q1 = new Corner(1021, 579, "Q1");
        Corner r1 = new Corner(1268, 581, "R1");

        University.getInstance().getMap().insertVertex(a1);
        University.getInstance().getMap().insertVertex(b1);
        University.getInstance().getMap().insertVertex(c1);
        University.getInstance().getMap().insertVertex(d1);
        University.getInstance().getMap().insertVertex(e1);
        University.getInstance().getMap().insertVertex(f1);
        University.getInstance().getMap().insertVertex(g1);
        University.getInstance().getMap().insertVertex(h1);
        University.getInstance().getMap().insertVertex(i1);
        University.getInstance().getMap().insertVertex(j1);
        University.getInstance().getMap().insertVertex(k1);
        University.getInstance().getMap().insertVertex(l1);
        University.getInstance().getMap().insertVertex(m1);
        University.getInstance().getMap().insertVertex(n1);
        University.getInstance().getMap().insertVertex(ñ1);
        University.getInstance().getMap().insertVertex(o1);
        University.getInstance().getMap().insertVertex(p1);
        University.getInstance().getMap().insertVertex(q1);
        University.getInstance().getMap().insertVertex(r1);

        // horizontales
        University.getInstance().getMap().insertWEdgeNDG(4, 29, new EdgeAux(34, 613, 139, "E3A1", 4, 29));
        University.getInstance().getMap().insertWEdgeNDG(29, 30, new EdgeAux(34, 1010, 467, "A13B1", 29, 30));
        University.getInstance().getMap().insertWEdgeNDG(30, 31, new EdgeAux(34, 1157, 110, "B13C1", 30, 31));
        University.getInstance().getMap().insertWEdgeNDG(31, 32, new EdgeAux(34, 1331, 110, "C13D1", 31, 32));
        University.getInstance().getMap().insertWEdgeNDG(32, 33, new EdgeAux(34, 1454, 110, "D13E1", 32, 33));
        University.getInstance().getMap().insertWEdgeNDG(35, 36, new EdgeAux(34, 1157, 265, "G13H1", 35, 36));
        University.getInstance().getMap().insertWEdgeNDG(38, 39, new EdgeAux(34, 1329, 330, "J13K1", 38, 39));
        University.getInstance().getMap().insertWEdgeNDG(41, 42, new EdgeAux(34, 1178, 404, "M13N1", 41, 42));
        University.getInstance().getMap().insertWEdgeNDG(43, 44, new EdgeAux(34, 1422, 414, "Ñ13O1", 43, 44));
        University.getInstance().getMap().insertWEdgeNDG(45, 46, new EdgeAux(34, 885, 551, "P13Q1", 45, 46));
        University.getInstance().getMap().insertWEdgeNDG(46, 47, new EdgeAux(34, 1333, 562, "Q13R1", 46, 47));
        University.getInstance().getMap().insertWEdgeNDG(24, 40, new EdgeAux(34, 677, 410, "B23L1", 24, 40));
        // verticales
        University.getInstance().getMap().insertWEdgeNDG(29, 34, new EdgeAux(34, 790, 226, "A13F1", 29, 34));
        University.getInstance().getMap().insertWEdgeNDG(30, 35, new EdgeAux(34, 721, 263, "B13G1", 30, 35));
        University.getInstance().getMap().insertWEdgeNDG(31, 36, new EdgeAux(34, 1171, 350, "C13H1", 31, 36));
        University.getInstance().getMap().insertWEdgeNDG(32, 39, new EdgeAux(34, 1296, 350, "D13K1", 32, 39));
        University.getInstance().getMap().insertWEdgeNDG(33, 37, new EdgeAux(34, 1421, 350, "E13I1", 33, 37));
        University.getInstance().getMap().insertWEdgeNDG(34, 40, new EdgeAux(34, 756, 457, "F13L1", 34, 40));
        University.getInstance().getMap().insertWEdgeNDG(35, 40, new EdgeAux(34, 756, 457, "G13L1", 35, 40));
        University.getInstance().getMap().insertWEdgeNDG(35, 41, new EdgeAux(34, 1333, 562, "G13M1", 35, 41));
        University.getInstance().getMap().insertWEdgeNDG(36, 38, new EdgeAux(34, 1333, 562, "H13J1", 36, 38));
        University.getInstance().getMap().insertWEdgeNDG(38, 42, new EdgeAux(34, 1333, 562, "J13N1", 38, 42));
        University.getInstance().getMap().insertWEdgeNDG(39, 43, new EdgeAux(34, 1333, 562, "K13Ñ1", 39, 43));
        University.getInstance().getMap().insertWEdgeNDG(37, 44, new EdgeAux(34, 1333, 562, "I13O1", 37, 44));
        University.getInstance().getMap().insertWEdgeNDG(40, 45, new EdgeAux(34, 1333, 562, "L13P1", 40, 45));
        University.getInstance().getMap().insertWEdgeNDG(41, 45, new EdgeAux(34, 1333, 562, "M13P1", 41, 45));
        University.getInstance().getMap().insertWEdgeNDG(42, 46, new EdgeAux(34, 1333, 562, "N13Q1", 42, 46));
        University.getInstance().getMap().insertWEdgeNDG(43, 46, new EdgeAux(34, 1223, 728, "Ñ13Q1", 43, 46));
        University.getInstance().getMap().insertWEdgeNDG(44, 47, new EdgeAux(34, 1419, 531, "O13R1", 44, 47));
        University.getInstance().getMap().insertWEdgeNDG(37, 39, new EdgeAux(34, 1452, 330, "I13K1", 37, 39));

    }
}
