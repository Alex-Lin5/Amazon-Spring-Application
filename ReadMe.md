# Amazon Spring Boot Application
This is a backend project in Spring boot framework that implements online shopping functions, and use MySQL database to persist user data.

## Feature
- Achieved CI/CD from project building to containerized deployment with Jenkins service
- Implemented container environment deployment in Docker and Kubernetes
- Supported AWS deployment under ECR, EKS, EC2, RDS services
- Used Spring Testing to address unit testing with dependency injection
- Applied AOP concepts to facilitate global logging and exception handling

## Kubernetes
spring boot application cannot communicate to database via JDBC in minikube, but curl command between pods is available

## Docker
Host machine in Mac/Windows cannot communicate to docker container in host mode
- https://docs.docker.com/network/drivers/host/#docker-desktop
- https://docs.docker.com/desktop/networking


