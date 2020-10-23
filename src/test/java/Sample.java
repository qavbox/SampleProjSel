import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sample {
    private static final Logger logger = LogManager.getLogger(Sample.class);

    public static void main(String []args){
        logger.info("sample........");
        logger.warn("sample warn........");
    }
}
