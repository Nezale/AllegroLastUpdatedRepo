package com.example.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.apache.log4j.Logger;

import javax.naming.ServiceUnavailableException;
import java.util.List;

@Service
public class RepoService {

    private final static Logger log = Logger.getLogger(RepoService.class);

    public Repo getLastUpdatedRepo() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<Repo>> response = restTemplate.exchange(
                    "https://api.github.com/users/allegro/repos?sort=pushed",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Repo>>() {
                    });
            return response.getBody().stream().findFirst().get();
        } catch(HttpServerErrorException.ServiceUnavailable e){
            log.error("Github api v3 is down: ", e);
        }
        return null;
   }

}