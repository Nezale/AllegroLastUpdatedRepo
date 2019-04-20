package com.example.demo.repo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class RepoController {

    private RepoService repoService = new RepoService();

    @RequestMapping(path="/last-updated",produces = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.GET)
    public HttpEntity<Repo> lastUpdatedRepo() {
        Repo repo = repoService.getLastUpdatedRepo();
        return new ResponseEntity<>(repo, HttpStatus.OK);
    }


}
