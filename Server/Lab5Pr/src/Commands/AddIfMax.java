package Commands;

import MusicBand.MusicBand;
import Utilities.*;

import java.io.IOException;

public class AddIfMax implements Commandable {
    @Override
    public String execute(Object o) throws IOException {
        BandList bandList = new BandList();
        ServerSender.send("",2);
        Pair<Boolean, MusicBand> res =(Pair<Boolean,MusicBand>) ByteToObject.Cast(ServerReceiver.receive());
        if (res.getKey()) {
            if (bandList.addIfMax(res.getValue()))
                return ("Музыкальная группа добавлена в коллекцию!");
            else
                return ("Музыкальная группа меньше чем максимальная,группа не добавлена.");
        } else {
            return ("Что-то пошло не так,группа не добавлена.");
        }
    }

    @Override
    public String getName() {
        return "add_if_max";
    }
}
