package is.stanton.andy.routes;

import com.google.inject.Guice;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.guice.CamelModuleWithMatchingRoutes;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.BeforeClass;
import org.junit.Test;

public class HttpRoutesTest extends CamelTestSupport {
    private static final String MOCK_PING = "mock:ping";

    @EndpointInject(uri = MOCK_PING)
    protected MockEndpoint resultEndpoint;

    @Test
    public void testPingEndpoint() throws Exception {
        resultEndpoint.expectedMessageCount(1);

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpHost target = new HttpHost("127.0.0.1", 8080);
            HttpRequest request = new HttpGet("/ping");
            client.execute(target, request);
        }

        resultEndpoint.assertIsSatisfied();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        Guice.createInjector(new CamelModuleWithMatchingRoutes() {
            @Override
            protected void configure() {
                super.configure();
                bind(HttpRoutesTest.class);
            }
        });
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                from("jetty:http://0.0.0.0:8080/ping?chunked=false").to(MOCK_PING);
            }
        };
    }
}