package by.javatr.action.impl.admin.registration_page;

import by.javatr.action.BaseCommand;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.DateConverter;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;
import by.javatr.entity.en_um.Role;
import by.javatr.entity.en_um.UserStatus;
import by.javatr.service.FactoryService;
import by.javatr.service.ServiceException;
import by.javatr.service.impl.UserInfoServiceImpl;
import by.javatr.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class EditUserPageAdminCommand extends BaseCommand {
    private static final String PASSPORT_IDENTIFICATION_NUMBER_USER = "userPassportIdentificationNumber";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String message_error = "";
        RequestDispatcher dispatcher = null;
        //Boolean sts = false;
        String idPassportUser = request.getParameter(PASSPORT_IDENTIFICATION_NUMBER_USER);
        FactoryService factoryService = FactoryService.getInstance();
        UserInfoServiceImpl userInfoService = factoryService.get(DaoSql.UserInfoDao);
        UserInfo userInfoFromDB = new UserInfo();

        try {
        if (idPassportUser != null || !idPassportUser.equals("null") || !idPassportUser.trim().equals("")) {
            userInfoFromDB = userInfoService.findByIdNumberPassport(idPassportUser);

            UserServiceImpl userService = factoryService.get(DaoSql.UserDao);
            User userFromDB = userService.findByIdentity(userInfoFromDB.getId());

            request.setAttribute("role_user", userFromDB.getRole());
            request.setAttribute("login_user", userFromDB.getLogin());
            request.setAttribute("surname_user", userInfoFromDB.getSurname());

            request.setAttribute("name_user", userInfoFromDB.getName());
            request.setAttribute("second_name_user", userInfoFromDB.getSecondName());
            request.setAttribute("birth_date_user", DateConverter.converterStringFromDate(userInfoFromDB.getBirthDate()));
            request.setAttribute("country_user", userInfoFromDB.getCountry());
            request.setAttribute("pass_issue_date_user", DateConverter.converterStringFromDate(userInfoFromDB.getPassportIssueDate()));
            request.setAttribute("pass_iss_authotity_user", userInfoFromDB.getPassportIssuingAuthority());
            request.setAttribute("pass_id_number_user", userInfoFromDB.getPassportIdentificationNumber());
            request.setAttribute("pass_s_number_user", userInfoFromDB.getPassportSerialNumber());
            request.setAttribute("address_reg_user", userInfoFromDB.getPassportAddressRegistration());
            request.setAttribute("address_res_user", userInfoFromDB.getPassportAddressResidence());
            request.setAttribute("phone_number_user", userInfoFromDB.getPhoneNumber());
            request.setAttribute("phone_number2_user", userInfoFromDB.getSecondPhoneNumber());
            request.setAttribute("e_mail_user", userInfoFromDB.getEmail());

            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/edit_user_page.jsp");
        }
        else {
            message_error = "Select the user to edit!";
            dispatcher =  request.getRequestDispatcher("/WEB-INF/jsp/selected_user_page.jsp");
        }
        } catch (ServiceException e) {
            message_error = e.getMessage();
            e.printStackTrace();
        }

        try {
            dispatcher.forward(request, response);
            // передача запроса/управления другому ресурсу на сервере;
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
