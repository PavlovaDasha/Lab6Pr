package Commands;

import Utilities.BandList;

import java.io.IOException;

public class CountLessThanNumber implements  Commandable {
    @Override
    public String execute(Object o) throws IOException {
        BandList bandList = new BandList();
        int nop;
        try {
            nop = Integer.parseInt((String)o);
        } catch (NumberFormatException ex) {
            return ("wrong id");

        }
        return bandList.countLessThanNumberOfParticipants(nop);

    }

    @Override
    public String getName() {
        return "count_less_than_number_of_participants";
    }
}
