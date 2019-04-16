package com.example.demo.repo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
public class RepoController {

    //** **//

    @RequestMapping(path="/", method= RequestMethod.GET)
    public HttpEntity<Repo> lastUpdatedRepo(){

        Repo repo = RepoService.getLastUpdatedRepo();
        return new ResponseEntity<>(repo, HttpStatus.OK);
    }


}
