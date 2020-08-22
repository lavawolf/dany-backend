package org.latdofb.dany.client.wit.model;

import lombok.Getter;

@Getter
public class BaseEntity {
    private Integer id;
    private String name;
    private String role;
    private int start;
    private int end;
    private String body;
    private double confidence;
    private BaseEntity[] entities;
    private String value;
    private String type;
}
