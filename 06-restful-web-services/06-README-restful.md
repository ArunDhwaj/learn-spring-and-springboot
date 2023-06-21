
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
                                                                                                                                                                    <scope>runtime</scope>
                                                                                                                                                                </dependency>
