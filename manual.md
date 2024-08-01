## Kubernetes
- `minikube start`, start cluster in local machine
- `kubectl apply -f *.yaml`, run config for deploy and service
- `kubectl logs <podName> --all-containers`, check log of the pod

### AWS resources
- aws eks ctl 
https://eksctl.io/installation/
- aws eks getting started 
  https://docs.aws.amazon.com/eks/latest/userguide/getting-started-eksctl.html
- 

### check out
- `kubectl get pods -o wide`, find out current status of pods
- `kubectl get svc/service`
- `kubectl get deploy/deployments`
- `kubectl get jobs`
- `kubectl get pvc`
- `kubectl describe pvc <pvcName>`
- `kubectl describe pv <pvName>`

### clean up
- `kubectl delete pods --all`
- `kubectl delete services <serviceName>`
- `kubectl delete deployment <deployName>`
- `kubectl delete pvc <pvcName> --grace-period=0 --force`

### communication
communication between microservices
- https://dev.to/narasimha1997/communication-between-microservices-in-a-kubernetes-cluster-1n41

execute into pod
- `kubectl exec --stdin --tty <podName> -- /bin/bash`
## Network
test jdbc connection from command line
- `java utils.dbping MYSQL $DB_USERNAME $DB_PASSWORD $DB_NAME`
find out processes in listening
- `netstat -tulpn | grep LISTEN`
- `lsof -i -P -n | grep LISTEN`
