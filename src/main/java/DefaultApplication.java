import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(DefaultApplication.class);

    public static void main(String[] args){
        LOGGER.debug("This is a debug message");
        LOGGER.info("This is an info message");
        LOGGER.warn("This is a warn message");
        LOGGER.error("This is an error message");
    }
}
