package Commands;

import Utilities.BandList;

import java.io.IOException;

public class Sort implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        BandList bandList = new BandList();
        if (bandList.getSize()>0){
            bandList.sort();
            return "Коллекция успешно отсортирована.";
        }
        else return "Коллекция пуста.";

    }

    @Override
    public String getName() {
        return "sort";
    }
}
