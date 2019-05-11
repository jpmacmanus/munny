package munny.ui.CommandLine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// maps commands (strings) to elements of type t
class CommandParser<T> {

    private final Scanner scanner;
    private Map<String,T> commands;

    CommandParser() {
        this.commands = new HashMap<>();
        this.scanner  = new Scanner(System.in);
    }

    void addCommand(String cmd, T out) {
        commands.put(cmd,out);
    }

    private Optional<T> parse(String cmd) {
//        System.out.println("PARSING CMD: <" + cmd + ">");
        return Optional.ofNullable(commands.get(cmd));
    }

    // TODO filter out more empty-ish inputs
    private String nextNonEmptyInput() {
        String s = "";
        while (s.equals("")) {
            s = scanner.nextLine();
        }
        return s;
    }

    Optional<T> parseNextCmd() {
        return parse(nextNonEmptyInput());
    }

    // TODO try catch inputmismatch exceptions
    double parseNextDouble() {
        return scanner.nextDouble();
    }

    boolean parseNextBool() {
        return scanner.nextBoolean();
    }

    String parseNextString() {
        return scanner.nextLine();
    }

    Date parseNextDate() throws ParseException {

        Date date = new Date();
//            System.out.println(" [Date format: dd-mm-yyyy] ");
        String dateString = nextNonEmptyInput();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        date = format.parse(dateString);

        return date;
    }
}
