package is.stanton.andy;

import com.google.inject.Guice;

import javax.naming.InitialContext;

public class EntryPoint {
    public static void main(String[] args) throws Exception {
        new InitialContext();
        Guice.createInjector();
    }
}
