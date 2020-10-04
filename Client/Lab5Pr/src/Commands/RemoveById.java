package Commands;

import Utilities.BandList;

import java.io.IOException;

public class RemoveById implements  Commandable {
    @Override
    public String execute(Object o) throws IOException {
        BandList mbList = new BandList();
        int id;
        try {
            id = Integer.parseInt((String)o);
        } catch (NumberFormatException ex) {
           return ("wrong id parameter");

        }
        mbList.removeById(id);
        return "Элемент с id "+id+" удалён из коллекции.";
    }

    @Override
    public String getName() {
        return "remove";
    }
}
