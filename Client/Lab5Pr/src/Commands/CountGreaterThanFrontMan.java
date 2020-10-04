package Commands;

import MusicBand.Person;
import Utilities.BandList;
import Utilities.Pair;

import java.io.IOException;

public class CountGreaterThanFrontMan implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        BandList bandList = new BandList();
        Pair<Boolean, Person> fmp = Person.input("front man");
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
