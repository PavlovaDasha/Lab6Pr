package Commands;

import MusicBand.MusicBand;
import Utilities.BandList;
import Utilities.ByteToObject;
import Utilities.ServerReceiver;
import Utilities.ServerSender;

import java.io.IOException;

public class Update implements Commandable {
    @Override
    public String execute(Object o) throws IOException {
        int id;
        BandList bandList = new BandList();
        try {
            id = Integer.parseInt((String)o);
        } catch (NumberFormatException ex) {
            return ("Некоректный ввод аргумента.");

        }

        MusicBand band = bandList.findById(id);

        if (band == null) {
            return ("Группы с таким айди не существует.");

        }
        ServerSender.send(band,4);

        MusicBand musicBand = (MusicBand) ByteToObject.Cast(ServerReceiver.receive());

        if (musicBand!=null) {
             bandList.removeById(id);
             bandList.add(musicBand,id);
            return ("Группа успешно обновлена");
        } else {
          return ("Что-то пошло не так,группа не обновлена.");
        }
    }

    @Override
    public String getName() {
        return "update";
    }
}
