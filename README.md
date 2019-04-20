# AllegroLastUpdatedRepo

[![Build Status](https://travis-ci.com/Nezale/AllegroLastUpdatedRepo.svg?token=6toCu4DPGu1TovDxJPhE&branch=master)](https://travis-ci.com/Nezale/AllegroLastUpdatedRepo)

Rest api which show an actual last updated(pushed) allegro repo on github. <br />
In sorting I used the pushed_at property because it fitted in with the allegro officiall github repository update date. <br />
There are some differences between pushed_at and updated_at properties that have been described here : https://stackoverflow.com/questions/15918588/github-api-v3-what-is-the-difference-between-pushed-at-and-updated-at
### Technologies
- Java8
- SpringBoot
- Lombok
- Maven
- Heroku
- TravisCI
- Docker

### Supported API endpoints ###

    /api/v1/last-updated
#### Method
> #### GET ###
Show last updated allegro repository on github

### Getting started
> Using docker
    
    mvn package
    
    docker build -t <build_name> .
    
    docker run -p 8080:8080 <build_name>

> Using Spring-Boot
    
    mvn spring-boot:run
    

### Link to the api ###
https://allegro-last-updated-repo-app.herokuapp.com/api/v1/last-updated

### Todo:
- [ ] Write test for RepoService when throwing ServiceUnavailable exception
- [ ] Fix badly written "503 error handled" commit (little fuck up :disappointed: )


### Ideas for next iterations:

 - Add an additional Angular client to consume API and add some views
 - Add more endpoints like most frequently updated repo
 - Configure Airbrake Error Monitoring on heroku

