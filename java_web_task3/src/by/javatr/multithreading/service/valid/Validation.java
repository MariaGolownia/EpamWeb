package by.javatr.multithreading.service.valid;
import org.apache.log4j.Logger;

import javax.xml.bind.ValidationException;
import java.io.File;
import java.util.List;

/**
 * Validation is designed to validate different parameters of system
 * **/

public class Validation {
    private static Logger LOGGER = Logger.getLogger(Validation.class);
    private static final int MAX_NUMBER_OF_STREAMS = 6;
    private static final int MIN_NUMBER_OF_STREAMS = 4;

    public Boolean checkFile(File file) {
        LOGGER.debug("Start checkFile");
        return file.exists()  && file.canRead();
    }

    public void validateUniqueNumberOfStreams (List<Integer> arrayOfUniqueNumbers) {
        LOGGER.debug("Start validateUniqueNumberOfStreams");
        try {
        if (arrayOfUniqueNumbers.size() > MAX_NUMBER_OF_STREAMS
                || arrayOfUniqueNumbers.size() < MIN_NUMBER_OF_STREAMS)
            throw new ValidationException("\nThe number of threads cannot be less "
                    + MIN_NUMBER_OF_STREAMS + " or more than " + MAX_NUMBER_OF_STREAMS + "!\n"
                    + "Trying to create a several streams is not successful!");
        }
        catch (ValidationException ex) {
            ex.printStackTrace();
        }
    }
}
