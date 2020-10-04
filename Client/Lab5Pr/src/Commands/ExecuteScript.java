package Commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteScript implements Commandable {
    @Override
    public String execute(Object o) throws IOException {
//        if (command.length < 2){
//            System.out.println("syntax: executeScript <filename>");
//            return true;
//        }
//
//        String fileName = command[1];
//
//        if (this.calledScripts.contains(fileName)) {
//            System.out.println("infinite recursion detected");
//            return false;
//        } else {
//            this.calledScripts.add(fileName);
//        }
//
//        FileReader fr;
//
//        try {
//            fr = new FileReader(fileName);
//        } catch (FileNotFoundException e) {
//            System.out.println("не найден файл скрипта");
//            e.printStackTrace();
//            this.calledScripts.remove(fileName);
//            return true;
//        }
//
//        BufferedReader br = new BufferedReader(fr);
//        String s;
//
//        Scanner temp = Utilities.IoHelper.in;
//        Utilities.IoHelper.in = new Scanner(br);
//
//        try {
//            while (Utilities.IoHelper.in.hasNextLine()) {
//                s = Utilities.IoHelper.in.nextLine();
//                System.out.println(">>>" + s);
//                if (!execution(s)) {
//                    Utilities.IoHelper.in = temp;
//                    this.calledScripts.remove(fileName);
//                    return false;
//                }
//            }
//
//            br.close();
//            fr.close();
//        } catch (IOException ex) {
//            System.out.println("error reading from file");
//            Utilities.IoHelper.in = temp;
//            this.calledScripts.remove(fileName);
//            return true;
//        }
//
//        Utilities.IoHelper.in = temp;
//        this.calledScripts.remove(fileName);
//        return true;
        return null;
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
