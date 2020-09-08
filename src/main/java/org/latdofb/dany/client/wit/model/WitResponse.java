package org.latdofb.dany.client.wit.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WitResponse {
    private String text;
    private IntentModel[] intents;
    private EntityWrapper entities;

}
