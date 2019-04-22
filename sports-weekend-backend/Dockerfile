FROM adoptopenjdk/openjdk12:jre-12.33
WORKDIR /
ADD target/sports-weekend-backend-0.0.1-SNAPSHOT.jar sports-weekend-backend.jar
ADD games.csv games.csv
EXPOSE 8080
CMD java -jar sports-weekend-backend.jar
