package org.latdofb.dany.client.wit.api;

import org.latdofb.dany.client.wit.model.BaseEntity;
import org.latdofb.dany.config.DefaultFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "wit.ai", url = "https://api.wit.ai", configuration = DefaultFeignConfig.class)
public interface WitClientApi {

    @GetMapping("/message")
    BaseEntity summarize(@RequestHeader("Authorization") String token, @RequestParam String q);
}
