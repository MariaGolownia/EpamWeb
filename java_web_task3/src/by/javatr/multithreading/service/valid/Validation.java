package by.javatr.multithreading.service.valid;
import javax.xml.bind.ValidationException;
import java.util.List;

public class Validation {
    private static final int MAX_NUMBER_OF_STREAMS = 6;
    private static final int MIN_NUMBER_OF_STREAMS = 4;

    public void validateUniqueNumberOfStreams (List<Integer> arrayOfUniqueNumbers) {
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
