package munny.ui;

import munny.model.*;

import java.util.*;

public class CommandLineInterface implements UserInterface {

    private final CommandParser<Integer> parser;
    private final CommandLinePrinter printer;
    private final MunnyFactory factory;
    private MunnyInterface budget;

    public CommandLineInterface() {
        factory = new ConcreteMunnyFactory();
        printer = new CommandLinePrinter();
        parser = new CommandParser<>();

        // list commands here
        parser.addCommand("exit", -1);
        parser.addCommand("review",1);
        parser.addCommand("help",2);
        parser.addCommand("load",3);
        parser.addCommand("unload",4);
        parser.addCommand("init",5);
    }

    public void start() {
        printer.printWelcome();
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
            // System.out.println(">>> OPCODE: " + opcode);
            execute(opcode);
        }

        printer.printGoodbye();
    }

    // TODO refactor both command parsing and command execution into one big "command handler"

    private void execute(int opcode) {
        switch(opcode) {
            case 1 :
                callReview();
                break;
            case 2 :
                printer.printHelp();
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

    private void callReview() {
        if (!budgetLoaded()) {
            printer.printError("No budget currently loaded.");
        }
        else {
            budget.review();
        }
    }

    private void initialise() {
        budget = factory.createMunnyInstance();
    }

    @Override
    public double reviewAccount(BankAccount account) {
        return 0;
    }

    @Override
    public boolean reviewPayment(Payment payment) {


        return false;
    }
}
