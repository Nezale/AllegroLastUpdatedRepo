package com.example.demo.repo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Repo extends ResourceSupport {

    private String name;
    private String html_url;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime pushed_at;

    public Repo(){}

    @JsonCreator
    public Repo(@JsonProperty("name") String name, @JsonProperty("html_url") String html_url,
                @JsonProperty("pushed_at") LocalDateTime pushed_at){
        this.name = name;
        this.html_url = html_url;
        this.pushed_at = pushed_at;
    }
}
