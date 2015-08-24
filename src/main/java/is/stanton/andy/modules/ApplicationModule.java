package is.stanton.andy.modules;

import is.stanton.andy.processors.PingEndpoint;
import is.stanton.andy.routes.HttpRoutes;
import org.apache.camel.guice.CamelModuleWithMatchingRoutes;

import java.util.Arrays;

public class ApplicationModule extends CamelModuleWithMatchingRoutes {
    @Override
    protected void configure() {
        super.configure();
        Arrays.asList(
                PingEndpoint.class,
                HttpRoutes.class
        ).stream().forEach(this::bind);
    }
}
