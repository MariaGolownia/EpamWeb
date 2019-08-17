package by.javatr.action;

import by.javatr.action.impl.*;
import by.javatr.action.impl.about_page.AboutPage;
import by.javatr.action.impl.authorization_page.AuthorizationPageCommand;
import by.javatr.action.impl.authorization_page.AuthorizationPageUserSubmitCommand;
import by.javatr.action.impl.location_page.LocationPageCommand;
import by.javatr.action.impl.order_page.ActionStartOrder;
import by.javatr.action.impl.order_page.OrderPageCommand;
import by.javatr.action.impl.payment_page.PaymentPageCommand;
import by.javatr.action.impl.selected_user_page.RegistrationPageCommand;
import by.javatr.action.impl.selected_user_page.UserPageCommand;

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
        this.commands.put(CommandName.MAIN_PAGE, new MainPageCommand());
        this.commands.put(CommandName.ORDER_PAGE, new OrderPageCommand());
        this.commands.put(CommandName.PAYMENT_PAGE, new PaymentPageCommand());
        this.commands.put(CommandName.START_ORDER, new ActionStartOrder());
        this.commands.put(CommandName.ABOUT_PAGE, new AboutPage());
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
