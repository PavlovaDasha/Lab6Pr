package Commands;

import java.io.IOException;

public class Exit implements CommandWithoutArg {
    @Override
    public String execute(Object o) throws IOException {
        return null;
    }

    @Override
    public String getName() {
        return "exit";
    }
}
