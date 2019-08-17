package by.javatr.action.impl.selected_user_page;

import by.javatr.action.BaseCommand;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.DateConverter;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;
import by.javatr.entity.en_um.Role;
import by.javatr.entity.en_um.UserStatus;
import by.javatr.service.ServiceException;
import by.javatr.service.impl.UserInfoServiceImpl;
import by.javatr.service.impl.UserServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationPageCommand extends BaseCommand {
    private static final String USER_LOGIN = "userLogin";
    private static final String USER_PASSWORD = "userPassword";
    private static final String SURNAME_USER = "userSurname";
    private static final String NAME_USER = "userName";
    private static final String SECOND_NAME_USER = "userSecondName";
    private static final String BIRTH_DATE_USER = "userBirthDate";
    private static final String COUNTRY_USER = "userCountry";
    private static final String PASSPORT_ISSUE_DATE_USER = "userPassportIssueDate";
    private static final String PASSPORT_ISSUING_AUTHORITY_USER = "userPassportIssuingAuthority";
    private static final String PASSPORT_IDENTIFICATION_NUMBER_USER = "userPassportIdentificationNumber";
    private static final String PASSPORT_SERIAL_NUMBER_USER = "userPassportSerialNumber";
    private static final String USER_PASSPORT_ADDRESS_REGISTRATION = "userPassportAddressRegistration";
    private static final String PASSPORT_ADDRESS_RESIDENCE_USER = "userPassportAddressResidence";
    private static final String PHONE_NUMBER_USER = "userPhoneNumber";
    private static final String SECOND_PHONE_NUMBER_USER = "userSecondPhoneNumber";
    private static final String EMAIL_USER = "userEmail";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = null;
        Boolean sts = false;

        String userLogin = request.getParameter(USER_LOGIN);
        String userPassword = request.getParameter(USER_PASSWORD);
        String surnameUser = request.getParameter(SURNAME_USER);
        String nameUser = request.getParameter(NAME_USER);
        String secondNameUser = request.getParameter(SECOND_NAME_USER);
        String birthDateUser = request.getParameter(BIRTH_DATE_USER);
        String countryUser = request.getParameter(COUNTRY_USER);
        String passportIssueDateUser = request.getParameter(PASSPORT_ISSUE_DATE_USER);
        String passportIssuingAuthorityUser = request.getParameter(PASSPORT_ISSUING_AUTHORITY_USER);
        String passportIdentificationNumberUser = request.getParameter(PASSPORT_IDENTIFICATION_NUMBER_USER);
        String passportSerialNumberUser = request.getParameter(PASSPORT_SERIAL_NUMBER_USER);
        String userPassportAddressRegistration = request.getParameter(USER_PASSPORT_ADDRESS_REGISTRATION);
        String passportAddressResidenceUser = request.getParameter(PASSPORT_ADDRESS_RESIDENCE_USER);
        String phoneNumberUser = request.getParameter(PHONE_NUMBER_USER);
        String secondPhoneNumberUser = request.getParameter(SECOND_PHONE_NUMBER_USER);
        String emailUser = request.getParameter(EMAIL_USER);


        try {
            UserServiceImpl userService = factoryService.get(DaoSql.UserDao);
            User userNew = new User();
            userNew.setLogin(userLogin);
            userNew.setPassword(userPassword);
            userNew.setUserStatus(UserStatus.ACTIVE);
            userNew.setRole(Role.USER);

            Integer id = userService.save(userNew);

            UserInfoServiceImpl userInfoService = factoryService.get(DaoSql.UserInfoDao);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(id);
            userInfo.setSurname(surnameUser);
            userInfo.setName(nameUser);
            userInfo.setBirthDate(DateConverter.converterDateFromString(birthDateUser));
            userInfo.setSecondName(secondNameUser);
            userInfo.setCountry(countryUser);
            userInfo.setPassportIssueDate(DateConverter.converterDateFromString(passportIssueDateUser));
            userInfo.setPassportSerialNumber(passportSerialNumberUser);
            userInfo.setPassportIdentificationNumber(passportIdentificationNumberUser);
            userInfo.setPassportIssuingAuthority(passportIssuingAuthorityUser);
            userInfo.setPassportAddressRegistration(userPassportAddressRegistration);
            userInfo.setPassportAddressResidence(passportAddressResidenceUser);
            userInfo.setPhoneNumber(Long.valueOf(phoneNumberUser));
            if (secondPhoneNumberUser != null && secondPhoneNumberUser != "")
                userInfo.setSecondPhoneNumber(Long.valueOf(secondPhoneNumberUser));
            userInfo.setEmail(emailUser);

            userInfoService.save(userInfo);

            sts = true;
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        if (sts)
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/payment_page.jsp");
        else
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error_page.jsp");

        try {
            dispatcher.forward(request, response);
            // передача запроса/управления другому ресурсу на сервере;
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
