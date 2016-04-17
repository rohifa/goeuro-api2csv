# goeuro-api2csv
translate api call to csv

Dev test based on https://github.com/goeuro/dev-test

## Build
the project can be built using gradle.
To create a fat jar, plugin shadowjar https://github.com/johnrengelman/shadow has been configured.

Usage is simple, just `gradle shadowJar` in the main folder

##Project structure
The project is divided in 4 packages:
controllers, models, persistence, services (self explanatory), each package has one class only.

Main class only gets the input data and calls the api2csv method of the controller.

Relevant external dependencies used are:
Jackson for json deserialization
HttpComponent Fluent API for REST API calls
Lombok for cleaner classes with less boilerplate

## Notes
since it's a CLI tool, printing to system.out has been used to show relevant errors to the user







