package by.javatr.action;
import by.javatr.service.FactoryService;

public abstract class BaseCommand implements Command {
    protected  FactoryService factoryService = FactoryService.getInstance();
}
