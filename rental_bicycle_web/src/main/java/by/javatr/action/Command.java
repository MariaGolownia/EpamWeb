package by.javatr.action;
import by.javatr.service.FactoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    public void execute(HttpServletRequest request, HttpServletResponse response);
}
