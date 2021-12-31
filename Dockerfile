FROM openjdk:latest
COPY target/flutterwave-0.0.1-SNAPSHOT.jar flutterwave-0.0.1-SNAPSHOT.jar
CMD ["sh", "-c", "java -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar /flutterwave-0.0.1-SNAPSHOT.jar"]
# use this instead and comment out the line above to build for linode
# ENTRYPOINT ["java","-jar","/flutterwave-0.0.1-SNAPSHOT.jar"]