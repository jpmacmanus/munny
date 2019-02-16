package munny.ui;

import munny.model.ConcreteMunnyFactory;
import munny.model.MunnyFactory;
import munny.model.MunnyInterface;
import munny.model.Payment;

import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface {

    private final CommandParser<Integer> parser;

    private final MunnyFactory factory;
    private MunnyInterface budget;

    public CommandLineInterface() {

        factory = new ConcreteMunnyFactory();

        parser = new CommandParser<>();
        // list commands here
        parser.addCommand("exit", -1);
        parser.addCommand("report",1);
        parser.addCommand("help",2);
        parser.addCommand("load",3);
        parser.addCommand("unload",4);
        parser.addCommand("init",5);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        // opcode 0 => do nothing
        int opcode = 0;

        // exits on "exit" command
        while (opcode != -1) {
            System.out.println("> Enter a command:");
            Optional<Integer> cmd = parser.parse(scanner.nextLine());
            if (cmd.isPresent()) {
                opcode = cmd.get();
            }
            else {
                opcode = 0;
                System.out.println("> Command not recognised: type 'help' for a list of commands");
            }
            System.out.println(">>> OPCODE: " + opcode);
            execute(opcode);
        }
    }

    // TODO refactor both command parsing and command execution into one big "command handler"

    private void execute(int opcode) {
        switch(opcode) {
            case 1 :
                System.out.println("> report");
                callReport();
                break;
            case 2 :
                printHelp();
                break;
            case 3 :
                // TODO via JSON etc
                break;
            case 4 :
                unload();
                break;
            case 5 :
                initialise();
                break;
        }
    }

    private void unload() {
        this.budget = null;
    }

    private boolean budgetLoaded() {
        return budget != null;
    }

    private void callReport() {
        if (!budgetLoaded()) {
            // say something
            System.out.println("\n>>> Error: No budget loaded!\n");
        }
        else {
            budget.report();
        }
    }

    private void initialise() {
        budget = factory.createMunnyInstance();
    }


    // TODO refactor this so descriptions are added to commands when they're defined and print by looping through.
    private void printHelp() {
        System.out.println("Here's a list of possible commands:"); // TODO
        System.out.println("  - help   : lists possible commands.\n"
                         + "  - report : generates a report of the current loaded budget.\n"
                         + "  - init   : initialises a brand new budget, with default the default parameters.\n"
                         + "              (start date: today, period length: 7 days, number of periods: 52)\n"
                         + "  - load _ : loads the specified budget [TODO]\n"
                         + "  - unload : unloads the currently loaded budget.\n"
        );
    }

    @Override
    public void requestBalance(MunnyInterface m, Map<String, Integer> accounts) {

    }

    @Override
    public void requestReview(MunnyInterface m, Queue<Payment> payments) {

    }
}
