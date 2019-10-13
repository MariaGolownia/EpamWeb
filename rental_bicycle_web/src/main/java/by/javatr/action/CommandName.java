package by.javatr.action;
import by.javatr.action.impl.MainPageCommand;
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

public enum CommandName {
    SET_LOCALE,

    AUTHORIZATION_PAGE,
    AUTHORIZATION_PAGE_USER_SUBMIT  ,

    LOCATION_PAGE ,
    USER_PAGE ,

    REGISTER_COMMAND,
    REGISTRATION_PAGE,

    MAIN_PAGE,

    ORDER_PAGE,
    START_ORDER,

    PAYMENT_PAGE ;
    /*SET_LOCALE(new SetLocale()),

    AUTHORIZATION_PAGE (new AuthorizationPageCommand()),
    AUTHORIZATION_PAGE_USER_SUBMIT (new AuthorizationPageUserSubmitCommand()),

    LOCATION_PAGE (new LocationPageCommand()),
    USER_PAGE (new UserPageCommand()),

    REGISTER_COMMAND (new RegistrationCommand()),
    REGISTRATION_PAGE (new RegistrationPageCommand()),

    MAIN_PAGE (new MainPageCommand()),

    ORDER_PAGE (new OrderPageCommand()),
    START_ORDER (new ActionStartOrder()),

    PAYMENT_PAGE (new PaymentPageCommand());

    private Command command;

    CommandName(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }*/
}
