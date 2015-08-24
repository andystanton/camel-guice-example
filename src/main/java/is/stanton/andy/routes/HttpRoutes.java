package is.stanton.andy.routes;

import is.stanton.andy.processors.PingEndpoint;
import org.apache.camel.builder.RouteBuilder;

public class HttpRoutes extends RouteBuilder {
    public static final String URI_PATTERN = "%s:http://%s:%d%s?%s";
    public static final String COMPONENT_NAME = "jetty";
    public static final String HOST = "0.0.0.0";
    public static final int PORT = 8080;
    public static final String PING_ENDPOINT = "/ping";
    public static final String PING_OPTIONS = "chunked=false";

    @Override
    public void configure() throws Exception {
        from(String.format(
                        HttpRoutes.URI_PATTERN,
                        HttpRoutes.COMPONENT_NAME,
                        HttpRoutes.HOST,
                        HttpRoutes.PORT,
                        HttpRoutes.PING_ENDPOINT,
                        HttpRoutes.PING_OPTIONS)
        ).bean(PingEndpoint.class);
    }
}
