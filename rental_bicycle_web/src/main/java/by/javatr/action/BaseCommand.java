package by.javatr.action;
import by.javatr.service.FactoryService;

public abstract class BaseCommand implements Command {
    FactoryService factoryService = FactoryService.getInstance();
}
