package Commands;

import Utilities.ClientReceiver;
import Utilities.ClientSender;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Commands {
    private static Map<String, Commandable> commands = new TreeMap<>();
    private static ArrayList<String> history = new ArrayList<>();
    public static ArrayList<String> getHistory() {
        return history;
    }

    public Commandable getCommand(String commandname) {
        return commands.get(commandname);
    }

    public static void setCommands(Map<String, Commandable> commands) {
        Commands.commands = commands;
    }

    public void regist(Commandable... commands) {
        for (Commandable command : commands) {
            Commands.commands.put(command.getName(), command);
        }
    }
    public void addToHistory(String commandName){
        if (commandName.equals("history") == false)
            history.add(commandName);
    }

    /**
     * @param commandName имя комманды
     */
    public Map<Commandable,String> executeCommand(String commandName) {
        Map<Commandable,String > map = new HashMap<Commandable, String>();
        String[] nameAndArgument = commandName.split(" ");
        commandName = commandName.replace(" ", "");
        if (commandName.equals("exit")) {
            System.out.println("Завершаю работу.");
            map.put(commands.get(nameAndArgument[0]), null);
            ClientSender.send(map);
            System.exit(0);
        }
        else {
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                System.out.println("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
            } else {
                try {
                    CommandWithoutArg commandWithoutArg = (CommandWithoutArg) commands.get(nameAndArgument[0]);
                    try {
                        String s = nameAndArgument[1];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (Exception e) {
                        map.put(commands.get(nameAndArgument[0]), null);
                        return map;
                    }
                } catch (Exception e) {
                    try {
                        String s = nameAndArgument[2];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (IndexOutOfBoundsException e1) {
                        try {
                            map.put(commands.get(nameAndArgument[0]), nameAndArgument[1]);
                            return map;
                        } catch (IndexOutOfBoundsException e2) {
                            System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        }
                    }
                }
            }
            }
        }
        return null;
    }
}
