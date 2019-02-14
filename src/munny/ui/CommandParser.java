package munny.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// maps commands (strings) to elements of type t
public class CommandParser<T> {

    private Map<String,T> commands;

    CommandParser() {
        this.commands = new HashMap<>();
    }

    void addCommand(String cmd, T out) {
        commands.put(cmd,out);
    }

    Optional<T> parse(String cmd) {
        return Optional.ofNullable(commands.get(cmd));
    }
}
