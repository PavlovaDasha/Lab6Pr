package Utilities;

import MusicBand.MusicBand;
import MusicBand.Person;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Map;


public class ClientReceiver {
    public static DatagramSocket sock;
    public static int clientport;

    public static void receive() throws SocketTimeoutException {
        byte[] buffer = new byte[10000];
        try {
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            sock.setSoTimeout(2500);
            sock.receive(reply);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(reply.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            Object obj = objectInputStream.readObject();
            byteArrayInputStream.close();
            objectInputStream.close();
            Map<Object, Integer> answer = (Map<Object, Integer>) obj;
            if (answer.entrySet().iterator().next().getValue() == 0) {
                System.out.println("Ответ с сервера: " + answer.entrySet().iterator().next().getKey());
            } else if (answer.entrySet().iterator().next().getValue() == 1) {
                System.out.println("Ответ с сервера: " + answer.entrySet().iterator().next().getKey());
                System.out.print("$ ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String s = reader.readLine();
                ClientSender.send(s);
                ClientReceiver.receive();
            } else if (answer.entrySet().iterator().next().getValue() == 2) {
                Pair<Boolean, MusicBand> res = MusicBand.input();
                ClientSender.send(res);
                ClientReceiver.receive();
            } else if (answer.entrySet().iterator().next().getValue() == 3) {
                Pair<Boolean, Person> fmp = Person.input("front man");
                ClientSender.send(fmp);
                ClientReceiver.receive();

            } else if (answer.entrySet().iterator().next().getValue() == 4) {
                MusicBand b = (MusicBand)answer.entrySet().iterator().next().getKey();
                boolean updateRes = b.edit();
                if (updateRes)  ClientSender.send(b);
                 else ClientSender.send(null);
                ClientReceiver.receive();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            System.out.println("Возможно сервер занят или выключен,попробуйте ещё раз.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
