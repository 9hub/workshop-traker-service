# workshop-tracker-server
### Prerequisites
+ Install java 8
+ Install maven 3.x
### Create project spring boot
1. Go to  url: 
[https://start.spring.io/](https://start.spring.io/)
2. Select Maven Project
3. Select Language Java
4. Select spring boot version 2.1.4 or 2.x
5. Project Metadata: 
+ **group:** *com.9hub*
+ **artifact:** *workshop-tracker-server*
6. For finally clip in *Generate Project*

### Run project
1. Donwload  and copy project to  work path and estract
2. Execute in console
```shell
 mvn clean compile package
```
### Hello world in spring boot
1. Update the file  pom.xml
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```
2. Change class home and add requets model
3. Execute in console
```shell
 mvn clean compile package

 java -jar target\workshop-tracker-server.jar
```
4. Got to url 
[http://localhost:8080/](http://localhost:8080/)
### Structure Code
Create your code Structure:
```txt
+- myproject
  +- model
  +- dao
  +- controller
  +- service
```
