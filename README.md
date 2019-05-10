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
+- workshop-tracker-server
  +- model
  +- dao
  +- controller
  +- service
```
### Conexion mysql
1. Create the data base in mysql *db_workshop_tracker*
2. Add dependence mysql and jpa to file pom.xml
```xml
    <!-- data base dependences -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency> 
```
### Implement model entity of *customer*
1. Implement the class *Customer*, You can import more the package *javax.pesistence*
```java
import javax.persistence.Entity;
@Entity
public class Customer {

}
```
2. You define the atributos of class customer,  the key atributo  is *id*
```java
@Entity
@Table(name = "customers")
public class Customer {
    @javax.persistence.Id
    private Long Id;
    ...

}
```
3. For and, you can compiler with comants and it make the table *customers*:
```shell
 mvn clean compile package
```
### Implement dao repository of *customer*
1. Create and implement the interface *CustomerRepository* for example:
```java
package com.hub.workshoptrackerserver.dao;

import com.hub.workshoptrackerserver.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
```
2. For and, you can compiler with comants:
```shell
 mvn clean compile package
```

### Implement service of *customer*
1. Create and implent the class *CustomerService* for example:
```java
package com.hub.workshoptrackerserver.service;

import com.hub.workshoptrackerserver.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
}
```
2. For and, you can compiler with comants:
```shell
 mvn clean compile package
```
### Implement controller of *customer*
1. Create and implements the class *CustomerController* for example:
```java
package com.hub.workshoptrackerserver.controller;

import com.hub.workshoptrackerserver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
}
```
2. For and, you can compiler with comants:
```shell
 mvn clean compile package
```

