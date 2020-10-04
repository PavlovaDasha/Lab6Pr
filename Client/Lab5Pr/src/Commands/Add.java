package Commands;

import MusicBand.MusicBand;
import Utilities.BandList;
import Utilities.Pair;

import java.io.IOException;

public class Add implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        BandList bandList = new BandList();
        Pair<Boolean, MusicBand> res = MusicBand.input();
        if (res.getKey()) {
            bandList.add(res.getValue());
            return ("Музыкальная группа добавлена в коллекцию!");
        } else {
            return ("Что-то пошло не так,группа не добавлена.");
        }
    }

    @Override
    public String getName() {
        return "add";
    }
}
