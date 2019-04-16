package com.example.demo.repo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo extends ResourceSupport {

    private String name;
    private String url;


    @JsonCreator
    public Repo( @JsonProperty("name") String name, @JsonProperty("html_url") String url){
        this.name = name;
        this.url = url;
    }


    public String getName() {
        return name;
    }
    public String getUrl(){return url;}

    public void setName(String name) {
        this.name = name;
    }

}
