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
    AUTHORIZATION_PAGE_USER_SUBMIT,

    LOCATION_PAGE,
    USER_PAGE,

    REGISTER_COMMAND,
    REGISTRATION_PAGE,
    REGISTRATION_PAGE_ADMIN,

    MAIN_PAGE,

    ORDER_PAGE,
    START_ORDER,

    PAYMENT_PAGE ;

}
