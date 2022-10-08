import description.Commands;
import service.CommandService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;


public class Initializer {
    private final static Map<String, Consumer<Scanner>> commands = new HashMap<>();
    private static final CommandService commandService = new CommandService();

    static {
        initializer();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name");
        String command = scanner.nextLine().toLowerCase();
        System.out.println("enter help for help :-)");

        while (!command.equals("exit")) {
            command = scanner.nextLine().toLowerCase();
            commands.getOrDefault(command,
                            scanner1 -> System.out.println("incorrect command"))
                    .accept(scanner);
        }
    }

    private static void initializer() {
        commands.put(Commands.HELP.value, scanner -> Arrays.stream(Commands.values()).forEach(System.out::println));
        commands.put(Commands.EXIT.value, scanner -> System.out.println("exit is initialized,bye bye ..."));
        commands.put(Commands.SHOW.value, commandService.getShowCommand());
        commands.put(Commands.SAVE.value, commandService.getSaveCommand());
        commands.put(Commands.ADD.value, commandService.getAddCommand());
    }
}
