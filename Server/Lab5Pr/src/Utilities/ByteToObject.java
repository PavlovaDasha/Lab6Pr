package Utilities;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class ByteToObject {
    public static Object Cast(byte[] buf) {
        Object obj = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Map<Integer, Object> map = (Map<Integer, Object>) objectInputStream.readObject();
            if (CreateServer.serverIsAvaible) {
                CreateServer.currentClientPort = map.entrySet().iterator().next().getKey();
                obj = map.entrySet().iterator().next().getValue();
            } else if (CreateServer.currentClientPort == map.entrySet().iterator().next().getKey()) {
                obj = map.entrySet().iterator().next().getValue();
            } else{
                return ByteToObject.Cast(ServerReceiver.receive());
            }
            byteArrayInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

