package com.aidr.app.dto;

import java.util.List;

public class TaggerAttribute {

    private String code;

    private String description;

    private String name;

    private Integer nominalAttributeID;

    private TaggerUser users;

    private List<TaggerLabel> nominalLabelCollection;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNominalAttributeID() {
        return nominalAttributeID;
    }

    public void setNominalAttributeID(Integer nominalAttributeID) {
        this.nominalAttributeID = nominalAttributeID;
    }

    public TaggerUser getUsers() {
        return users;
    }

    public void setUsers(TaggerUser users) {
        this.users = users;
    }

    public List<TaggerLabel> getNominalLabelCollection() {
        return nominalLabelCollection;
    }

    public void setNominalLabelCollection(List<TaggerLabel> nominalLabelCollection) {
        this.nominalLabelCollection = nominalLabelCollection;
    }

}
