# webeC - Graded Exercise

## Project

### Team members

Petra Kohler & Jonas Gysin

### Description
This is a simple web application for the module Web Engineering at the FHNW.
'I need Coffee' helps coffee-lovers to collect and rate the different coffee blends they tasted.
Coffee-lovers are able to add new blends (coffee-mixes) to the database, edit them and leave ratings & reviews.

This project was generated with
<a href="https://angular.io/cli" underline="none">Angular CLI</a>
version 13.3.3. As a UI component library we used
<a href="https://material.angular.io/" underline="none"> Material Angular UI</a>
and as a e2e Testing Framework we implemented
<a href="https://www.cypress.io/" underline="none">Cypress </a>.
Our code was formatted with the help of
<a href="https://prettier.io/" underline="none">Prettier </a>.

Entities:
* CoffeeMix
* Bean
* Rating

Relations:
* CoffeeMix - Bean (n:n)
* CoffeeMix - Raiting (1:n)

### Individual

Rich-Client with Angular 13
Sophisticated and responsive design, Material UI

## Installation and run instructions

Consult this READ ME here or the RUN & INSTALLATION page in localhost:4200/about on how to run
the application.

### Run application backend

```
./gradlew bootRun
```

### Run tests

```
./gradlew test
```

## Frontend

### Install Angular
```
npm i @angular/cli
npm install
```

## Run
Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Build
Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## e2e Tests with Cypress
```
npx cypress open
```

## Prettier
```
npx prettier --check .
npx prettier --write .
```
