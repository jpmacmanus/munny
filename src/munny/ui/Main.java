package munny.ui;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CommandParser<Integer> pCmd = new CommandParser<>();

        // list commands here
        pCmd.addCommand("exit", -1);
        pCmd.addCommand("report",1);
        pCmd.addCommand("help",2);

        Scanner scanner = new Scanner(System.in);

        // opcode 0 => do nothing
        int opcode = 0;

        // exits on "exit" command
        while (opcode != -1) {
            Optional<Integer> cmd = pCmd.parse(scanner.nextLine());

            if (cmd.isPresent()) {
                opcode = cmd.get();
            }
            else {
                opcode = 0;
                System.out.println("Command not recognised: type 'help' for a list of commands"); // TODO
            }

            // execute command;
            // TODO create 'CommandExecuter' or something, maybe just a static method
            System.out.println("Command opcode:" + opcode);
        }

    }

}
