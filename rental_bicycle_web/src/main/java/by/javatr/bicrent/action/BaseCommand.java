package by.javatr.bicrent.action;
import by.javatr.bicrent.service.FactoryService;

public abstract class BaseCommand implements Command {
    protected  FactoryService factoryService = FactoryService.getInstance();

}
