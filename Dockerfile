# Maven
FROM maven:3-jdk-11
ADD . /fmba-backend-gateway
WORKDIR /fmba-backend-gateway
RUN ls -l
RUN mvn clean install

# Java App
FROM openjdk:11-jdk
VOLUME /tmp
COPY --from=0 "/fmba-backend-gateway/target/fmba-backend-gateway-*.jar" app.jar
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

#FROM maven:3-jdk-11
#VOLUME /tpm
#ADD target/*.jar app.jar
#RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]