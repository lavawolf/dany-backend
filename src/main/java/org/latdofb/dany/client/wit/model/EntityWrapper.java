package org.latdofb.dany.client.wit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EntityWrapper {

    @JsonProperty("keyword_important:keyword_important")
    private List<EntityModel> important;
}
