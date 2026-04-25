## Name: messenger backend
### Description
Simple centralised messenger backend with 1-to-1 chats only without encryption written on Java with using Spring Framework and other tools
### Features
- user registration
- 1-to-1 private chats
- realtime messaging
- message history in database
- online/offline status
### Architecture
- backend
	- registration module
	- messaging module ^20aeb6
	- online/offline status module
- database
### Tech stack
- Java 21
- Spring Boot 3.3.x
- Gradle
- PostgreSQL 16
- Spring WebSocket + STOMP
- Spring Security + JWT
- Spring Data JPA + Hibernate
- Lombok
- Validation
- Flyway
- JUnit 5 + Testcontainers