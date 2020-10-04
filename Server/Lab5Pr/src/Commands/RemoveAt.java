package Commands;

import Utilities.BandList;

import java.io.IOException;

public class RemoveAt implements Commandable {
    @Override
    public String execute(Object o) throws IOException {
        BandList bandList = new BandList();
        int id;
        try {
            id = Integer.parseInt((String)o);
        } catch (NumberFormatException ex) {
            return ("wrong id parameter");
        }
        bandList.removeAt(id);
        return "Элемент на месте "+id+" удалён." ;
    }

    @Override
    public String getName() {
        return "remove_at";
    }
}
