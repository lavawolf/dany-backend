package org.latdofb.dany.client.wit.service;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.latdofb.dany.client.wit.api.WitClientApi;
import org.latdofb.dany.client.wit.model.BaseEntity;
import org.latdofb.dany.client.wit.model.WitResponse;
import org.latdofb.dany.common.Const;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class WitService {

    private final WitClientApi witClientApi;

    @Async
    public Future<WitResponse> summarize(String request) {
        try {
            WitResponse summary = witClientApi.summarize("Bearer " + Const.TOKEN, request);
            return new AsyncResult<>(summary);
        } catch(FeignException ex) {
            System.out.println(ex.contentUTF8());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return new AsyncResult<>(null);
    }

    @Async
    public Future<WitResponse> audio(InputStream audio) {
        try {
            WitResponse summary = witClientApi.audio("Bearer " + Const.TOKEN, "audio/wav", audio);
            return new AsyncResult<>(summary);
        } catch(FeignException ex) {
            System.out.println(ex.contentUTF8());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return new AsyncResult<>(null);
    }

}
