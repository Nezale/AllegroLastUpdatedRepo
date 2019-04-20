package com.example.demo.Repo;

import com.example.demo.repo.Repo;
import com.example.demo.repo.RepoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RepoServiceTest {


    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ResponseEntity<List<Repo>> responseEntity= new ResponseEntity<>(HttpStatus.OK);
    @InjectMocks
    private RepoService repoService = new RepoService();

    @Test
    public void getLastUpdatedRepoTest() {

        Repo repo1 = new Repo("repo1","https://api.github.com/repos/allegro/swiftbox",LocalDateTime.parse("2019-04-17T15:48:18"));
        Repo repo2 = new Repo("repo2","https://api.github.com/repos/allegro/turnilo",LocalDateTime.parse("2019-04-16T11:00:24"));

        List<Repo> repos = new ArrayList<>();
        repos.add(repo1);
        repos.add(repo2);

        Mockito.when(restTemplate.exchange(
                ArgumentMatchers.eq("https://api.github.com/users/allegro/repos?sort=pushed"),
                ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.eq(null),
                ArgumentMatchers.<ParameterizedTypeReference<List<Repo>>>any()

        )).thenReturn(responseEntity);

        Mockito.when(responseEntity.getBody()).thenReturn(repos);

        Assert.assertEquals(repo1,repoService.getLastUpdatedRepo());
    }

}
