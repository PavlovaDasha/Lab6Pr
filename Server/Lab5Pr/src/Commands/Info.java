package Commands;

import Utilities.BandList;

import java.io.IOException;

public class Info implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        return new BandList().info();
    }

    @Override
    public String getName() {
        return "info";
    }
}
