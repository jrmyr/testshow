# RTFM

## Setup

### Initial creation

Go to [start.spring.io](start.spring.io) and create a Java 11 gradle project with these dependencies:
* Lombok
* Spring Web 
* Spring Data JPA
* PostgreSQL Driver
* Actuator
* Testcontainers


* Hamcrest

## Goals

### Misc
* Constructor Injection


### Mock-based testing
* ("API") Testing while programming is useful as it is fast and the created tests can remain
* Testable before having/deeding a real a DB
* Multiple assert -> assertAll -> parameterized test


* Private method testing is not useful:
  - Test in UserEntity 
  - --> code review: bad design
  - Test in ...
  - public Methode zum Abrufen des Grußes
  - Diese Methode benutzt dann wieder private/protected Methoden
  * *Outcome*: test only public contracts

### Testcontainers-based testing
* Postgres DB
* Einfaches init-Skript
* Checks auf DB-Ebene (auch gesondert mit JDBC um sicher zu sein)
