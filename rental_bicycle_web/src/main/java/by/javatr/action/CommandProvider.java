package by.javatr.action;

import by.javatr.action.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private static final CommandProvider instance = new CommandProvider();
    private Map<CommandName, Command> commands = new HashMap<>();

    private CommandProvider() {
        this.commands.put(CommandName.AUTHORIZATION_PAGE, new AuthorizationPageCommand());
        this.commands.put(CommandName.AUTHORIZATION_PAGE_USER_SUBMIT, new AuthorizationPageUserSubmitCommand());
        this.commands.put(CommandName.REGISTRATION_PAGE, new RegistrationPageCommand());
        this.commands.put(CommandName.LOCATION_PAGE, new LocationPageCommand());
        this.commands.put(CommandName.USER_PAGE, new UserPageCommand());
        this.commands.put(CommandName.MAIN_PAGE, new MainPageCommand());;
        this.commands.put(CommandName.RENT_PAGE, new OrderPageCommand());;
        this.commands.put(CommandName.PAYMENT_PAGE, new PaymentPageCommand());;

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
