package munny.ui.CommandLine;

import munny.model.*;
import munny.ui.UserInterface;

import java.text.ParseException;
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
        parser.addCommand("add account", 6);
        parser.addCommand("schedule payment", 7);

        printer.printWelcome();
    }


    // removed loop
    // TODO add some kind of callback system so model tells interface it's done.
    @Override
    public void nextTask() {

        // opcode 0 => do nothing
        int opcode = 0;

        // exits on "exit" command

        printer.printMsg("Enter a command:");
        Optional<Integer> cmd = parser.parseNextCmd();
        if (cmd.isPresent()) {
            opcode = cmd.get();
        }
        else {
            opcode = 0;
            printer.printError("Command not recognised: type 'help' for a list of commands");
        }
        execute(opcode);
    }

    private void execute(int opcode) {

        // a 'soft' command is one that will not invoke any callbacks or anything.
        // we call nextTask() ourselves immediately following one of these since
        // the model will not do this for us.
        boolean softCommand = true;

        switch(opcode) {
            case -1 :
                exit();
                break;
            case 1 :
                callReview();
                softCommand = false;
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
            case 6 :
                addNewAccount();
                break;
            case 7 :
                scheduleNewPayment();
                break;
        }
        if (softCommand) nextTask();
    }

    private void unload() {

        this.budget = null;
        printer.printMsg("Current budget has been unloaded.");
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
        printer.printMsg("Initialising new budget with default parameters...");
        budget = factory.createMunnyInstance(this);
        printer.printMsg("New budget loaded.");
        printer.printBudgetDetails(budget);
    }

    private void addNewAccount() {
        if (budgetLoaded()) {
            printer.printMsg("Enter the name of this account:");
            String name = parser.parseNextString();
            printer.printMsg("Enter the initial (current) balance:");
            double initialBalance = parser.parseNextDouble();

            printer.printMsg("Adding account . . .");
            budget.addAccount(name, initialBalance);
        }
        else {
            printer.printError("No budget loaded.");
        }
    }
    private void scheduleNewPayment() {
        if (budgetLoaded()) {
            try {
                printer.printMsg("Enter the amount:");
                double amount = parser.parseNextDouble();
                printer.printMsg("Enter the date:");

                Date date = parser.parseNextDate();
                printer.printMsg("Date parsed:");
                printer.printDate(date);

                printer.printMsg("Finally, enter a brief description:");


                String desc = parser.parseNextString();

                budget.schedulePayment(amount, date, desc);


            }
            catch (Exception e) {
                printer.printError("Payment scheduling failed");
                e.printStackTrace();
            }
        }
        else {
            printer.printError("No budget loaded.");
        }
    }

    private void exit() {
        printer.printGoodbye();
        System.exit(0);
    }

    @Override
    public double reviewAccount(BankAccount account) {
        printer.printAccount(account);
        printer.printMsg("Enter the current balance of this account.");
        return parser.parseNextDouble();
    }

    @Override
    public boolean reviewPayment(Payment payment) {
        printer.printPayment(payment);
        printer.printMsg("Has this payment been made yet?");
        // ask user whether it has been paid
        return parser.parseNextBool();
    }
}
