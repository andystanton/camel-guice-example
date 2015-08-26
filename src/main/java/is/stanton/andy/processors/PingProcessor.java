package is.stanton.andy.processors;

import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PingProcessor implements Processor {
    @Override
    public void process(final Exchange exchange) throws Exception {
        exchange.getOut().setHeader(HttpHeaders.CONTENT_TYPE, MediaType.PLAIN_TEXT_UTF_8);
        exchange.getOut().setBody("pong");
    }
}
