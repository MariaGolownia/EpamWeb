import by.javatr.webparsing.valid.ValidatorSAX;
import by.javatr.webparsing.valid.ValidatorSAXXSD;

public class Runner {
    public static void main(String[] args) {
        String fileName = "gems.xml";
        String schemaName = "gems.xsd";
        String logName = "logs/log.txt";
        ValidatorSAX validatorSAX = new ValidatorSAX(fileName, schemaName, logName);

        ValidatorSAXXSD validatorSAXXSD = new ValidatorSAXXSD(fileName, schemaName);

    }
}
