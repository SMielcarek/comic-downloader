# Comic downloader
Microservice which accesses the external API at https://xkcd.com/json.html and retrieves today's comic title.

## Compile project
To compile project, run maven command in the main project folder:

`mvn clean package`

## Run microservice
To run microservice, execute this command in the **target** folder:

`java -jar comic-downloader-1.0-SNAPSHOT.jar`

## Access microservice
Type following address in the browser:

`http://localhost:8080/comic`
