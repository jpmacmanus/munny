package munny.ui;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        CommandParser<Integer> pCmd = new CommandParser<>();

        // list commands here
        pCmd.addCommand("exit", -1);
        pCmd.addCommand("report",1);
        pCmd.addCommand("help",2);
        pCmd.addCommand("load",3);
        pCmd.addCommand("unload",4);
        pCmd.addCommand("init",5);

        Scanner scanner = new Scanner(System.in);

        // opcode 0 => do nothing
        int opcode = 0;

        // exits on "exit" command
        while (opcode != -1) {

            System.out.println("> Enter a command:");
            Optional<Integer> cmd = pCmd.parse(scanner.nextLine());

            if (cmd.isPresent()) {
                opcode = cmd.get();
            }
            else {
                opcode = 0;
                System.out.println("> Command not recognised: type 'help' for a list of commands");
            }
            // execute command;
            // TODO create 'CommandExecuter' or something, maybe just a static method
            System.out.println(">>> OPCODE: " + opcode);
            main.execute(opcode);
        }
    }

    private void execute(int opcode) {
        switch(opcode) {
            case 1 :
                System.out.println("> report");
                callReport();
                break;
            case 2 :
                System.out.println("> help");
                printHelp();
                break;
            case 5 :
                System.out.println("> init");
                break;
        }
    }

    private void callReport() {

    }

    private void printHelp() {
        System.out.println("Here's a list of possible commands:"); // TODO
    }

}
