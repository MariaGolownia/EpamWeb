package by.javatr.action;
import by.javatr.action.impl.*;
import by.javatr.action.impl.admin.registration_page.EditUserPageAdminCommand;
import by.javatr.action.impl.admin.registration_page.EditUserPageApplyAdminCommand;
import by.javatr.action.impl.admin.registration_page.RegistrationPageAdminCommand;
import by.javatr.action.impl.authorization_page.AuthorizationPageCommand;
import by.javatr.action.impl.authorization_page.AuthorizationPageUserSubmitCommand;
import by.javatr.action.impl.locale.SetLocale;
import by.javatr.action.impl.location_page.LocationPageCommand;
import by.javatr.action.impl.order_page.ActionStartOrder;
import by.javatr.action.impl.order_page.OrderPageCommand;
import by.javatr.action.impl.payment_page.PaymentPageCommand;
import by.javatr.action.impl.registration_page.RegistrationCommand;
import by.javatr.action.impl.selected_user_page.RegistrationPageCommand;
import by.javatr.action.impl.selected_user_page.UserPageCommand;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private static final CommandProvider instance = new CommandProvider();
    private Map<CommandName, Command> commands = new HashMap<>();
    private Command command;

    private CommandProvider() {
        //User's commands
        this.commands.put(CommandName.SET_LOCALE, new SetLocale());
        this.commands.put(CommandName.AUTHORIZATION_PAGE, new AuthorizationPageCommand());
        this.commands.put(CommandName.AUTHORIZATION_PAGE_USER_SUBMIT, new AuthorizationPageUserSubmitCommand());
        this.commands.put(CommandName.REGISTER_COMMAND, new RegistrationCommand());
        this.commands.put(CommandName.REGISTRATION_PAGE, new RegistrationPageCommand());
        this.commands.put(CommandName.LOCATION_PAGE, new LocationPageCommand());
        this.commands.put(CommandName.USER_PAGE, new UserPageCommand());
        this.commands.put(CommandName.MAIN_PAGE, new MainPageCommand());
        this.commands.put(CommandName.ORDER_PAGE, new OrderPageCommand());
        this.commands.put(CommandName.PAYMENT_PAGE, new PaymentPageCommand());
        this.commands.put(CommandName.START_ORDER, new ActionStartOrder());

        //Admin's commands
        this.commands.put(CommandName.REGISTRATION_PAGE_ADMIN, new RegistrationPageAdminCommand());
        this.commands.put(CommandName.EDIT_USER_PAGE_ADMIN, new EditUserPageAdminCommand());
        this.commands.put(CommandName.EDIT_USER_APPLY_COMMAND_ADMIN, new EditUserPageApplyAdminCommand());
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
