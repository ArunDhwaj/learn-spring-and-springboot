
Step: Swagger
=============

i) Dependency: 
<dependency>
<groupId>org.springdoc</groupId>
<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
<version>2.1.0</version>
</dependency>

ii) Swagger url: http://localhost:8080/swagger-ui/index.html

Step: Content Negotiation
==========================

i) Dependency for xml:
<dependency>
<groupId>com.fasterxml.jackson.dataformat</groupId>
<artifactId>jackson-dataformat-xml</artifactId>
</dependency>

Step: Internationalization
==========================

i) MessageSource messageSource

ii) Locale

iii) messages.properties

iv) messages_fr.properties


Step: API Versioning
==========================

i) URI

ii) Request params

iii) Custom header versioning

iv) Media type versioning


Step: HATEOAS
================

Hypermedia As the Engine Of Application State

i) Dependency:
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>


ii)  WebMvcLinkBuilder


Step: Filtering for Resr API
=============================

a) Static filtering,

b) Dynamic filtering


i) @JsonIgnore: It even work for xml format also. 

ii) @JsonIgnoreProperties: It will used at class level.

iii) 		
<dependency>
<groupId>com.fasterxml.jackson.dataformat</groupId>
<artifactId>jackson-dataformat-xml</artifactId>
</dependency>


Step: Actuator
================

Production ready metrics: It makes available all the production ready metrics.


Step: Spring Boot HAL Explorer
===============================

i) Dependency:

		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-rest-hal-explorer</artifactId>
		</dependency>

ii) Link:  
http://localhost:8080/explorer/index.html#uri=/


Step: JPA & Hibernate with H2 Database
======================================

i)In application.properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb

ii) Dependency

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

iii) Learning:
In JPA entity must create a default constructor.


Step: JPA & Hibernate with MySQL Database
======================================

i) Installing docker 
----------------------
a) https://tecadmin.net/how-to-install-docker-on-ubuntu-22-04/

ii) Launch MySQL as Docker Container
------------------------------------

$ docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=social-media-user --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE=social-media-database --name mysql --publish 3306:3306 mysql:8-oracle

In details the command is like below:
$ docker run --detach 
--env MYSQL_ROOT_PASSWORD=dummypassword 
--env MYSQL_USER=social-media-user 
--env MYSQL_PASSWORD=dummypassword 
--env MYSQL_DATABASE=social-media-database 
--name mysql 
--publish 3306:3306 
mysql:8-oracle


So, run on the terminal:
$ docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=social-media-user --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE=social-media-database --name mysql --publish 3306:3306 mysql:8-oracle

iii) mysqlsh commands
----------------------

a) mysqlsh install
----------------------
https://www.bojankomazec.com/2022/01/how-to-install-mysql-shell-on-ubuntu.html

mysqlsh 
\connect social-media-user@localhost:3306
\sql
\use social-media-database
select * from user_details;
select * from post;
\quit

iv) /pom.xml Modified
-----------------------

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.12</version>
</dependency>


v) /src/main/resources/application.properties Modified
------------------------------------------------------

#spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.show-sql=true
spring.datasource.url=jdbc:mysql://localhost:3306/social-media-database
spring.datasource.username=social-media-user
spring.datasource.password=dummypassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


vi) Docker commands
---------------------

a) Remove forcefully the stopped container
$ docker container rm -f <container_id>
Example:

$ docker container rm -f  37b01802f562d56bc9f18e1cacbe16d869f11bd4231b0c29f116ce32fb6c0932


vi) mysql-workbench install
-----------------------------
a) $ sudo snap install mysql-workbench-community

b) https://dev.mysql.com/doc/workbench/en/wb-sql-editor-snippets.html



vii) mysql workbench commands
-----------------------------

SELECT * FROM `social-media-database`.user_details;


Step: Spring Security
======================

i) POM Dependency

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

ii) application.properties

spring.security.user.name=username
spring.security.user.password=password

iii) Filter chains
--------------------
a) All requests should be authenticated
b) If a request is not authenticated, a web page is shown
c) Disable: CSRF -> POST, PUT

d) Configuration
e) FilterChain


