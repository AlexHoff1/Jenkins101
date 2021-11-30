import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultApplication {

    public static void main(String[] args){
        log.info("Application starting");
        log.error("This is an error message");
    }
}
