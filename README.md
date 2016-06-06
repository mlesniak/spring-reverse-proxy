# Introduction

This is a simple example of a reverse-proxy with spring-boot and zuul to provide support for deployments such as 
[blue-green](http://martinfowler.com/bliki/BlueGreenDeployment.html) deployments.



    --spring.config.location=src/main/resources/application.yaml
    http :8080/refresh
    
* no delete    

add startup scripts?
ansible?
eureka for service discovery
