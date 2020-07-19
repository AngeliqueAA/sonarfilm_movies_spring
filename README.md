# sonarfilm_movies_spring

sonarfilm_movies_spring is a **spring boot** project which communicate with a mongoDB database and expose URL in a RESTAPI. 

## Overview

This project use movies data and do a simple algo to treat some data and give the best movie  depending on 4 criterias.

Here a sample of the URI and the response :

**GET** apimovies

- return a list of all the movies present in DB

**GET** apimovies/title/{title} 

- return a list of movies which match with the given title

**GET** apimovies/search/first/{firstGenre}

- return a list of movies which match with the given genre (for example 'musical')

## Installation 

1. Make sure that you update the **application.properties** or the **run configuration** of Eclipse with your own credentials.

2. Then, build the project and the tests with the following commands : 

```
mvn clean install  
mvn verify
mvn spring-boot:run

```

3. You can now use the project.


## Related Project 

The DB use by this project is filled by a NodeJS job : [sonarfilm_data](https://github.com/AngeliqueAA/sonarfilm_data_node)