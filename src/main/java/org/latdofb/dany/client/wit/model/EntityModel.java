package org.latdofb.dany.client.wit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityModel {
    private String id;
    private String name;
    private String role;
    private int start;
    private int end;
    private String body;
    private double confidence;
    private List<EntityModel> entities;
    private String value;
    private String type;
}
