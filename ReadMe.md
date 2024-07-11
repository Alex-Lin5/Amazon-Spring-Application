# Amazon Spring Boot Application
This is a backend project in Spring boot framework

## Feature
- 

## Kubernetes
- `minikube start`, start cluster in local machine
- `kubectl apply -f *.yaml`, run config for deploy and service
- `kubectl get pods`, find out current status of pods
- `kubectl logs <podName> --all-containers`, check log of the pod

## Docker
Host machine in Mac/Windows cannot communicate to docker container in host mode
- https://docs.docker.com/network/drivers/host/#docker-desktop
- https://docs.docker.com/desktop/networking

find out processes in listening
- `netstat -tulpn | grep LISTEN`
- `lsof -i -P -n | grep LISTEN`

