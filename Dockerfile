from openjdk:23-ea-21-jdk
EXPOSE 9090
ADD ./target/AmazonSpringApplication.jar AmazonSpringApplication.jar
ENTRYPOINT ["java", "-jar", "AmazonSpringApplication.jar"]