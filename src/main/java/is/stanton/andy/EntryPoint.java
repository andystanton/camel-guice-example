package is.stanton.andy;

import com.google.inject.Guice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;

public class EntryPoint {
    private static Logger log = LoggerFactory.getLogger(EntryPoint.class);

    public static void main(String[] args) throws Exception {
        new InitialContext();
        Guice.createInjector();

        log.info("Running Camel + Guice example!");
        log.info("Press Ctrl-C to quit");
    }
}
