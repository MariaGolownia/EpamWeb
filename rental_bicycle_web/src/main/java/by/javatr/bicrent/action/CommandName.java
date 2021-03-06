package by.javatr.bicrent.action;

public enum CommandName {
    //User's commands
    SET_LOCALE,

    AUTHORIZATION_PAGE,
    AUTHORIZATION_PAGE_USER_SUBMIT,

    LOCATION_PAGE,
    USER_PAGE,

    REGISTER_COMMAND,
    REGISTRATION_PAGE,
    MAIN_PAGE,

    ORDER_PAGE,
    START_ORDER,

    PAYMENT_PAGE,

    //Admin's commands
    REGISTRATION_PAGE_ADMIN,
    EDIT_USER_PAGE_ADMIN,
    EDIT_USER_APPLY_COMMAND_ADMIN,
    ADD_NEW_CARD_ADMIN,
    GET_CURRENCY_ADMIN,
    USER_PAGEUP_BALANCE,
    DO_MAIN_PAY,
    FIND_ORDER,
    ORDER_PAGE_STATUS;

}
