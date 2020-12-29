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
* Testen bevor DB da

### Mock-based testing
* Testing while programming is useful
* Private method testing is not useful:
  - Test in UserEntity 
  - --> code review: bad design
  - Test in ...
  - public Methode zum Abrufen des Grußes
  - Diese Methode benutzt dann wieder private/protected Methoden
* Lektion: Testen von "öffentlichen Verträgen" 
* "API testing" is useful also for developing
* Mehrfach assert -> asser all -> parameterized test
* Testabdeckung: Wenn die mit jedem Commit mind. gleich bleibt wäre das schon ein Gewinn

### Testcontainers-based testing
* Postgres DB
* Einfaches init-Skript
* Checks auf DB-Ebene (auch gesondert mit JDBC um sicher zu sein)
