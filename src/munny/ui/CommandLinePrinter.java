package munny.ui;

public class CommandLinePrinter {

    // TODO refactor all the complicated printing to here

    void printMsg(String s) {
        System.out.println(s);
    }

    void printError(String s) {
        System.out.println("\n > ERROR: " + s + "\n");
    }

    void printWelcome() {
        System.out.println(
                "   Welcome to \n\n" +
                "      $$\\      $$\\ $$\\   $$\\ $$\\   $$\\ $$\\   $$\\ $$\\     $$\\ \n" +
                "      $$$\\    $$$ |$$ |  $$ |$$$\\  $$ |$$$\\  $$ |\\$$\\   $$  |\n" +
                "      $$$$\\  $$$$ |$$ |  $$ |$$$$\\ $$ |$$$$\\ $$ | \\$$\\ $$  / \n" +
                "      $$\\$$\\$$ $$ |$$ |  $$ |$$ $$\\$$ |$$ $$\\$$ |  \\$$$$  /  \n" +
                "      $$ \\$$$  $$ |$$ |  $$ |$$ \\$$$$ |$$ \\$$$$ |   \\$$  /   \n" +
                "      $$ |\\$  /$$ |$$ |  $$ |$$ |\\$$$ |$$ |\\$$$ |    $$ |    \n" +
                "      $$ | \\_/ $$ |\\$$$$$$  |$$ | \\$$ |$$ | \\$$ |    $$ |    \n" +
                "      \\__|     \\__| \\______/ \\__|  \\__|\\__|  \\__|    \\__|    \n" +
                "\n" +
                "    [Type 'help' for a list of commands]"
        );
    }


    void printHelp() {
        System.out.println("Here's a list of possible commands:"); // TODO
        System.out.println("  - help   : lists possible commands.\n"
                + "  - report : generates a report of the current loaded budget.\n"
                + "  - init   : initialises a brand new budget, with default the default parameters.\n"
                + "              (start date: today, period length: 7 days, number of periods: 52)\n"
                + "  - load _ : loads the specified budget [TODO]\n"
                + "  - unload : unloads the currently loaded budget.\n"
        );
    }

    void printGoodbye() {
        System.out.println("Goodbye!");
    }

}
