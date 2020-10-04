package Commands;

import Utilities.BandList;

import java.io.IOException;

public class FilterByNumberOfParticipants implements Commandable {
    @Override
    public String execute(Object o) throws IOException {
        int nop;
        BandList mbList = new BandList();
        try {
            nop = Integer.parseInt((String)o);
        } catch (NumberFormatException ex) {
            return ("Некоректный ввод аргумента,попробуйте ещё раз.");
        }
        String ans = mbList.filterByNumberOfParticipants(nop);
       if (ans.equals("")) return "Таких групп не найдено";
       else return "Следующие группы подходят под условие:"+ans;
    }

    @Override
    public String getName() {
        return "filter_by_number_of_participants";
    }
}
