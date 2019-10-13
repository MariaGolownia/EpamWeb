package by.javatr.action;
import by.javatr.entity.en_um.Role;
import by.javatr.service.FactoryService;
import java.util.EnumSet;
import java.util.Set;

public abstract class BaseCommand implements Command {
    protected  FactoryService factoryService = FactoryService.getInstance();

}
