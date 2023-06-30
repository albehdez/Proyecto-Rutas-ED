package util;

import java.util.ArrayList;

public class Util {
    public static ArrayList<String> getVertexsId(String x) {
        ArrayList<String> vertexsId = new ArrayList<String>(2);
        String[] parts = x.split("-");
        vertexsId.add(parts[0]);
        vertexsId.add(parts[1]);
        return vertexsId;
    }
}
