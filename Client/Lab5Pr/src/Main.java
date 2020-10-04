import Commands.*;
import Utilities.ClientReceiver;
import Utilities.ClientSender;
import Utilities.IoHelper;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * класс для исполнения программы
 */
public class Main {
    /**
     * метод для исполнения программы
     *
     * @param args входные значения
     */
    public static void main(String[] args) throws IOException {
        Commands commands = new Commands();
        commands.regist(new Show(), new Exit(), new Help(), new Info(), new Clear(), new RemoveById(),
                new ExecuteScript(), new Add(), new Sort(), new Update(), new AddIfMax(),
                new CountGreaterThanFrontMan(), new CountLessThanNumber(), new FilterByNumberOfParticipants(), new RemoveAt(), new Sort());
        IoHelper ioHelper = new IoHelper();
        IoHelper.in = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        ClientReceiver.sock = ds;
        ClientReceiver.clientport = ds.getLocalPort();
        while (true) {
            try {
                System.out.println("Введите команду для отправки на сервер: ");
                System.out.print("$ ");
                String s = IoHelper.in.nextLine();
                Map<Commandable, String> commandparamMap = commands.executeCommand(s);
                if (commandparamMap != null) {
                    ClientSender.send(commandparamMap);
                    try {
                        ClientReceiver.receive();
                    } catch (SocketTimeoutException e) {
                        System.out.println("Сервер не отвечает или занят,попробуйте ещё раз и убедитесь,что сервер работает.");
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("Программа прервана пользователем.");
                System.exit(0);
            }
        }
    }
}
