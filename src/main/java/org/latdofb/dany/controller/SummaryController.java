package org.latdofb.dany.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.latdofb.dany.client.wit.model.BaseEntity;
import org.latdofb.dany.client.wit.model.EntityModel;
import org.latdofb.dany.client.wit.model.WitResponse;
import org.latdofb.dany.client.wit.service.WitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/summary")
@RequiredArgsConstructor
public class SummaryController {
    @Autowired
    @Qualifier("json_main")
    private final ObjectMapper json;
    private final WitService witService;

    private final Logger log = LoggerFactory.getLogger(SummaryController.class);

    @GetMapping
    public String getSummary(@RequestBody String request) {
        Future<WitResponse> summaryAsync = witService.summarize(request);
        WitResponse response = null;
        try {
            response = summaryAsync.get();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return summarize(response);
    }

    private String summarize(WitResponse response) {
        if(response == null) return null;
        StringBuilder sb = new StringBuilder();
        for(EntityModel entity: response.getEntities().getImportant()) {
            sb.append(entity.getValue());
            sb.append(" ");
        }
        return sb.toString();
    }
}