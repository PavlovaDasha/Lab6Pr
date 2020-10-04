package Commands;

import Utilities.BandList;

import java.io.IOException;

public class Exit implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        System.out.println("Один из клиентов отключился,сохраняю коллекцию в файл.");
        new BandList().save(BandList.filePath);
        return null;

    }

    @Override
    public String getName() {
        return "exit";
    }
}
