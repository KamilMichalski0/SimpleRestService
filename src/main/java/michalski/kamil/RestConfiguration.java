package michalski.kamil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Autowired
    RestTemplateBuilder builder;


    @Bean
    public RestTemplateBuilder getRestTemplateBulider(){
        return new RestTemplateBuilder();
    }

    @Bean
    public RestTemplate bulidRestTemplate(RestTemplateBuilder builder){
        return getRestTemplateBulider().build();
    }
}
