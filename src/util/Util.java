package util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Util {
    public static ArrayList<String> getVertexsId(String x) {
        ArrayList<String> vertexsId = new ArrayList<String>(2);
        String[] parts = x.split("3");
        vertexsId.add(parts[0]);
        vertexsId.add(parts[1]);
        return vertexsId;
    }

    private static Object readObject(RandomAccessFile file) throws IOException, ClassNotFoundException {
        byte[] arrByte = new byte[file.readInt()];
        file.read(arrByte);
        return Convert.toObject(arrByte);
    }

    private static void writeObject(RandomAccessFile file, Object o) throws IOException {
        byte[] arrByte = Convert.toBytes(o);
        file.writeInt(arrByte.length);
        file.write(arrByte);
    }
}
