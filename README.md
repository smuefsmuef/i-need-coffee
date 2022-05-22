# webeC - Graded Exercise

## Project

### Team members

Petra Kohler & Jonas Gysin

### Description

This is a sample application for the module Web Engineering at the FHNW.
It shows a list of coffee blends (coffee mixes), allows to add and edit
new blends and to review a single cup of coffee.

Entities:
* CoffeeMix
* Bean
* Rating

Relations:
* CoffeeMix - Bean (n:n)
* CoffeeMix - Raiting (n:1)

### Individual

Rich-Client with Angular
Frontend with Materials UI, Prettier and e2e Tests

## Installation and run instructions

### Run application backend

```
./gradlew bootRun
```

### Run tests

```
./gradlew test
```

### Run Frontend
```
ng serve
```
Run ng serve for a dev server.
Navigate to http://localhost:4200/
