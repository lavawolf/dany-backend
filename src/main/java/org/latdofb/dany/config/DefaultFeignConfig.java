package org.latdofb.dany.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Contract;
import feign.Logger;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;


public class DefaultFeignConfig {
    private ObjectMapper json;

    @Autowired
    public DefaultFeignConfig(@Qualifier("json_main") ObjectMapper json) {
        this.json = json;
    }

    @Bean
    @Primary
    public Decoder feignDecoderDefault() {
        return new ResponseEntityDecoder(new JacksonDecoder(json));
    }

    @Bean
    @Primary
    public Encoder feignEncoderDefault() {
        return new JacksonEncoder(json);
    }

    @Bean
    @Primary
    public Contract contractDefault() {
        return new SpringMvcContract();
    }

    @Bean
    public Retryer retryer() {
        return Retryer.NEVER_RETRY;
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Logger logger() {
        return new Slf4jLogger("service");
    }
}
