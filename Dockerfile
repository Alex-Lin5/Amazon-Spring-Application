FROM eclipse-temurin:21
EXPOSE 9000
ADD ./target/AmazonSpringApplication.jar AmazonSpringApplication.jar
#RUN apt-get update \
#    && apt-get install -y net-tools

ENTRYPOINT ["java", "-jar", "AmazonSpringApplication.jar"]

#CMD ["tail", "-f", "/dev/null"]