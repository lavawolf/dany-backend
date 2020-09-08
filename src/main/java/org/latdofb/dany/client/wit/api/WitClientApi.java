package org.latdofb.dany.client.wit.api;

import org.latdofb.dany.client.wit.model.BaseEntity;
import org.latdofb.dany.client.wit.model.WitResponse;
import org.latdofb.dany.config.DefaultFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

@Component
@FeignClient(name = "wit.ai", url = "https://api.wit.ai", configuration = DefaultFeignConfig.class)
public interface WitClientApi {

    @GetMapping("/message")
    WitResponse summarize(@RequestHeader("Authorization") String token, @RequestParam String q);

    @PostMapping("/speech")
    WitResponse audio(@RequestHeader("Authorization") String token, @RequestHeader("Content-Type") String audioWav, @RequestBody InputStream input);
}
