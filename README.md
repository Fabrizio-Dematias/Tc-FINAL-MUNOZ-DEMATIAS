# Compilador TC26 - Proyecto de Técnicas de Compilación

## Configuración inicial del proyecto

### Creación del proyecto Maven

El primer paso para desarrollar nuestro compilador es crear la estructura básica del proyecto usando Maven, que nos ayudará con la gestión de dependencias y el ciclo de vida de construcción.

Para crear el proyecto, ejecutamos el siguiente comando Maven:

```bash
mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate -DarchetypeArtifactId="maven-archetype-quickstart" -DarchetypeGroupId="org.apache.maven.archetypes" -DarchetypeVersion="1.4" -DgroupId="com.compilador" -DartifactId="demo"

Durante la ejecución del comando, configuramos las siguientes propiedades:
* **groupId**: com.compilador
* **artifactId**: demo
* **version**: 1.0
* **package**: com.compilador

Esto genera la estructura básica del proyecto:

demo/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── compilador/
│   │               └── App.java
│   └── test/
│       └── java/
│           └── com/
│               └── compilador/
│                   └── AppTest.java
