# Content

## Mock-based testing
* ("API") Testing while programming is useful as it is fast and the created tests can remain
* Testable before having/needing a real DB
* Multiple assert -> assertAll -> parameterized test


## Testcontainers-based testing
* Postgres DB
* Einfaches init-Skript
* Checks auf DB-Ebene (auch gesondert mit JDBC um sicher zu sein)


## General notes
* Private method testing is not useful,  test only public contracts
* Do constructor injection! :-)
