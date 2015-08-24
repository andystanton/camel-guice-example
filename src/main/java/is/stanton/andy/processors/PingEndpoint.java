package is.stanton.andy.processors;

import com.google.common.net.MediaType;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.eclipse.jetty.http.HttpHeaders;

public class PingEndpoint implements Processor {
    @Override
    public void process(final Exchange exchange) throws Exception {
        Message out = exchange.getOut();
        out.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.PLAIN_TEXT_UTF_8);
        out.setBody("pong");
    }
}
