package com.example.demo.repo;

import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class RepoController {

    //** **//

    @RequestMapping(path="/updated", method= RequestMethod.GET)
    public HttpEntity<Repo> lastUpdatedRepo(){
        Repo repo = RepoService.getLastUpdatedRepoFromGithubApi(RepoService.getReposFromGithubApi());
        repo.add(linkTo(methodOn(RepoController.class).lastUpdatedRepo()).withRel("https://github.com/allegro/" + repo.getName()));
        repo.add(linkTo(methodOn(RepoController.class).lastUpdatedRepo()).withRel("https://api.github.com/users/allegro/repos?sort=pushed"));
        return new ResponseEntity<>(repo, HttpStatus.OK);
    }


}
