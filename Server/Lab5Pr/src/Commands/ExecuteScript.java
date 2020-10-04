package Commands;

import Utilities.BandList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteScript implements Commandable {
    @Override
    public String execute(Object o) throws IOException {

        String answer = "";
        String fileName = (String)o;
        if (BandList.calledScripts.contains(fileName)) {
            answer+=(" infinite recursion detected");
            return answer;
        } else {
            BandList.calledScripts.add(fileName);

            FileReader fr = null;

            try {
                fr = new FileReader(fileName);
            } catch (FileNotFoundException e) {
                answer += ("не найден файл скрипта");
                e.printStackTrace();
                BandList.calledScripts.remove(fileName);
                return answer;
            }

            BufferedReader br = new BufferedReader(fr);
            String s;

            Scanner scanner = new Scanner(br);

            try {
                while (scanner.hasNextLine()) {
                    s = scanner.nextLine();
                    answer += (">>>" + s+"\n");
                    answer += Commands.executeCommand(s);
                }
                BandList.calledScripts.remove(fileName);
                br.close();
                fr.close();
                BandList.calledScripts.remove(fileName);
                return answer;
            } catch (IOException ex) {
                answer += ("error reading from file");
                BandList.calledScripts.remove(fileName);
                return answer;
            }

        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
