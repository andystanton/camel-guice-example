package is.stanton.andy.routes;

import is.stanton.andy.processors.PingProcessor;
import org.apache.camel.builder.RouteBuilder;

import javax.inject.Inject;

public class HttpRoutes extends RouteBuilder {
    @Inject
    private PingProcessor pingProcessor;

    @Override
    public void configure() throws Exception {
        from("jetty:http://0.0.0.0:8080/ping?chunked=false").process(pingProcessor);
    }
}
