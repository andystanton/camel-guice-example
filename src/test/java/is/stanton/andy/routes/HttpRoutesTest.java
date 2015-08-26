package is.stanton.andy.routes;

import com.google.inject.Guice;
import is.stanton.andy.processors.PingProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.guice.CamelModuleWithMatchingRoutes;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRoutesTest {
    private static Logger log = LoggerFactory.getLogger(HttpRoutesTest.class);

    @Mock
    private PingProcessor pingProcessor;

    @Test
    public void testPingRoute() throws Exception {
        HttpHost target = new HttpHost("127.0.0.1", 8080);
        HttpRequest request = new HttpGet("/ping");

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(target, request)) {
            log.info(Integer.toString(response.getStatusLine().getStatusCode()));
        }
        Mockito.verify(pingProcessor).process(Mockito.any(Exchange.class));
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Guice.createInjector(new CamelModuleWithMatchingRoutes() {
            @Override
            protected void configure() {
                super.configure();
                bind(PingProcessor.class).toInstance(pingProcessor);
                bind(HttpRoutes.class);
            }
        });
    }
}