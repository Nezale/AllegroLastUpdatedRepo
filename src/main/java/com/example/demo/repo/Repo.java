package com.example.demo.repo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Repo extends ResourceSupport {

    private String name;
    private String html_url;


    @JsonCreator
    public Repo(@JsonProperty("name") String name, @JsonProperty("html_url") String html_url){
        this.name = name;
        this.html_url = html_url;
    }

}
