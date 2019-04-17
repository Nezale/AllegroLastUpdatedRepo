package com.example.demo.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RepoService {

    public Repo getLastUpdatedRepo() {
       RestTemplate restTemplate = new RestTemplate();
       ResponseEntity<List<Repo>> response = restTemplate.exchange(
               "https://api.github.com/users/allegro/repos?sort=pushed",
               HttpMethod.GET,
               null,
               new ParameterizedTypeReference<List<Repo>>() {});
       return response.getBody().stream().findFirst().get();
   }

}