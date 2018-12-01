package duoc.portafolio.montrealweb.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateClient {
    @Bean
    public RestTemplate restTemplate() {
//    	ClientHttpRequestFactory baseUrl = new ClientHttpRequestFactory("https://18146a2e.ngrok.io");
//    	return new RestTemplate(baseUrl);
        return new RestTemplate();
    }
}