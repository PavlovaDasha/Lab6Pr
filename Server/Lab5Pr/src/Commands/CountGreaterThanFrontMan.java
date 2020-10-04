package Commands;

import MusicBand.MusicBand;
import MusicBand.Person;
import Utilities.*;

import java.io.IOException;

public class CountGreaterThanFrontMan implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        BandList bandList = new BandList();
        ServerSender.send("",3);
        Pair<Boolean, Person> fmp =  (Pair<Boolean, Person>) ByteToObject.Cast(ServerReceiver.receive());
        if (!fmp.getKey() || fmp.getValue() == null) {
            return ("Что-то пошло не так,попробуйте ещё раз.");
        }
        Person frontMan = fmp.getValue();
        return "Количество групп,значение поля frontMan которых больше заданного ="+ bandList.countGreaterThanFrontMan(frontMan);
    }

    @Override
    public String getName() {
        return "count_greater_than_front_man";
    }
}
