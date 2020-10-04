package Commands;

import Utilities.BandList;

import java.io.IOException;

public class Clear implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        BandList bandList = new BandList();
        if (bandList.getSize()>0) {
            bandList.clear();
            return "Коллекция очищена.";
        }
        else return "Коллекция и так пустая.";
    }

    @Override
    public String getName() {
        return "clear";
    }
}
