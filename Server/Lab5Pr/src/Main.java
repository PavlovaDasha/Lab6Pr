import Commands.*;
import Utilities.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

/**
 * класс для исполнения программы
 */
public class Main {
    /**
     * метод для исполнения программы
     * @param args входные значения
     */
    public static void main (String[] args) throws IOException {

        if (args.length < 1) {
            System.out.println("отсутствует обязательный аргумент командной строки");
            System.exit(-1);
        }
        IoHelper.in = new Scanner(System.in);
        try {
             BandList.loadFile(args[0]); //TODO
        } catch (FileNotFoundException e) {
            System.out.println("Указанного файла не существует. Попробуйте начать заново");
            System.exit(-2);
        } catch (IOException e) {
            System.out.println("IOException при попытке открытия файла");
            System.out.println("выберите другой файл, программа завершает работу");
            e.printStackTrace();
            System.exit(-2);
        }
        Commands commands = new Commands();
        commands.regist(new Show(), new Exit(), new Help(), new Info(), new Clear(), new RemoveById(),
                new ExecuteScript(), new Add(), new Sort(), new Update(), new AddIfMax(),
                new CountGreaterThanFrontMan(), new CountLessThanNumber(), new FilterByNumberOfParticipants(), new RemoveAt(),new Sort());
        CreateServer.create();
        checkForExitSaveCommand();
        while (true) {
            Map<Commandable, String> commandStringMap;
            try {
                System.out.println("Ожидаю команду.");
                Object o = ByteToObject.Cast(ServerReceiver.receive());
                commandStringMap = (Map<Commandable, String>) o;
                CreateServer.serverIsAvaible=false;
                System.out.println("Выполняю команду "+commandStringMap.entrySet().iterator().next().getKey().getClass().getName());
                ServerSender.send(commandStringMap.entrySet().iterator().next().getKey().execute(commandStringMap.entrySet().iterator().next().getValue()),0);
                CreateServer.serverIsAvaible=true;
                if (!commandStringMap.entrySet().iterator().next().getKey().getClass().getName().equals("Common.Commands.Exit")) System.out.println("Отсылаю ответ клиенту с портом: "+ CreateServer.currentClientPort+".");
            }
            catch (ClassCastException | IOException e){
                ServerSender.send("Сообщение от Сервера:\"Произошла ошибка подключения,попробуйте ещё раз.\"\n",0);
            }

        }
    }
    public static void checkForExitSaveCommand() throws IOException {
        Thread backgroundReaderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (!Thread.interrupted()) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.equalsIgnoreCase("exit")) {
                            System.out.println("Завершаю работу.");
                            System.exit(0);
                        }
                        if (line.equalsIgnoreCase("save")) {
                            System.out.println("Сохраняю коллекцию в файл.");
                            new BandList().save(BandList.filePath);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundReaderThread.setDaemon(true);
        backgroundReaderThread.start();
    }
}