package is.stanton.andy.modules;

import com.google.inject.Provides;
import is.stanton.andy.processors.PingProcessor;
import is.stanton.andy.routes.HttpRoutes;
import org.apache.camel.component.jetty.JettyHttpComponent;
import org.apache.camel.component.jetty9.JettyHttpComponent9;
import org.apache.camel.guice.CamelModuleWithMatchingRoutes;
import org.apache.camel.guice.jndi.JndiBind;

public class ApplicationModule extends CamelModuleWithMatchingRoutes {
    @Override
    protected void configure() {
        super.configure();
        bind(PingProcessor.class);
        bind(HttpRoutes.class);
    }

    @Provides
    @JndiBind("jetty")
    private JettyHttpComponent jettyComponent() {
        JettyHttpComponent component = new JettyHttpComponent9();
        component.setMinThreads(10);
        component.setMaxThreads(20);
        return component;
    }
}
