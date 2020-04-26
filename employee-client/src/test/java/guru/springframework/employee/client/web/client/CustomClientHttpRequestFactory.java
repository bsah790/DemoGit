package guru.springframework.employee.client.web.client;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;

@Component
public class CustomClientHttpRequestFactory extends SimpleClientHttpRequestFactory {
    @Override
    protected void prepareConnection(HttpURLConnection connection,
                                     String httpMethod) throws IOException {

        super.prepareConnection(connection, httpMethod);
        if("DELETE".equals(httpMethod)) {
            connection.setDoOutput(true);
        }
    }
}
