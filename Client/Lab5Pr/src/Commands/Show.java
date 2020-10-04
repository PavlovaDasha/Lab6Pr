package Commands;

import Utilities.BandList;

import java.io.IOException;

public class Show implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        BandList bandList = new BandList();
        if (bandList.getSize()>0){
            return bandList.show();
        }
        else return "Коллекция пуста.";
    }

    @Override
    public String getName() {
        return "show";
    }
}
