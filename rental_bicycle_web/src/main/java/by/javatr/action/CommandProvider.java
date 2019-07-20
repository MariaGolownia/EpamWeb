package by.javatr.action;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private static final CommandProvider instance = new CommandProvider();
    private Map<CommandName, Command> commands = new HashMap<>();

    private CommandProvider() {
        this.commands.put(CommandName.MAIN_PAGE, new MainPageCommand());
        this.commands.put(CommandName.SEARCH_PRODUCT, new SearchProductCommand());
        this.commands.put(CommandName.REGISTRATION_PAGE, new RegistrationPageCommand());
    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public Command getCommand(final String cName) {
        CommandName commandName = CommandName.valueOf(cName.toUpperCase());

        Command result = commands.get(commandName);

        return result;
    }
}
