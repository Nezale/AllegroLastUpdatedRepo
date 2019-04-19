# AllegroLastUpdatedRepo

[![Build Status](https://travis-ci.com/Nezale/AllegroLastUpdatedRepo.svg?token=6toCu4DPGu1TovDxJPhE&branch=master)](https://travis-ci.com/Nezale/AllegroLastUpdatedRepo)

Rest api which show an actual last updated(pushed) allegro repo on github. <br />
In sorting I used the pushed_at property because it fitted in with the allegro officiall github repository update date. <br />
There are some differences between pushed_at and updated_at properties that have been described here : https://stackoverflow.com/questions/15918588/github-api-v3-what-is-the-difference-between-pushed-at-and-updated-at

### Technologies ###
- Java8
- SpringBoot
- lombok
- maven
- heroku
- travisCI

### Link to the api ###
https://allegro-last-updated-repo-app.herokuapp.com/api/v1/last-updated
