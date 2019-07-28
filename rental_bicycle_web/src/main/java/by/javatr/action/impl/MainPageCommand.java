package by.javatr.action.impl;

import by.javatr.action.BaseCommand;
import by.javatr.entity.Location;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainPageCommand extends BaseCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        Location selectedLocation = (Location) session.getAttribute("selectedLocation");
        if (selectedLocation != null) {
            String selectedLocationInformation = selectedLocation.getCountry() + ", " +
                    selectedLocation.getCity() + ", " + selectedLocation.withoutCountryAndCityToString();
            request.setAttribute("locationName", selectedLocationInformation);
        }

        UserInfo selectedUserInfo = (UserInfo) session.getAttribute("selectedUserInfo");
        if (selectedUserInfo != null) {
            String selectedUserInformation = selectedUserInfo.getSurname() + ", " +
                    selectedUserInfo.getName() + ", " + selectedUserInfo.getPassportIdentificationNumber();
            request.setAttribute("userName", selectedUserInformation);
        }

        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_page.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
