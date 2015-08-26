package is.stanton.andy;

import javax.naming.InitialContext;

public class EntryPoint {
    public static void main(String[] args) throws Exception {
        new InitialContext();

        System.out.println("Running Camel + Guice example on http://127.0.0.1:8080/ping");
        System.out.println("Press Ctrl-C to quit");
    }
}
