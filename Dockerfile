FROM openjdk:latest
COPY target/flutterwave-0.0.1-SNAPSHOT.jar flutterwave-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/flutterwave-0.0.1-SNAPSHOT.jar"]