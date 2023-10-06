# Ejercicio de arquitectura hexagonal con springboot 

Este proyecto es una aplicación Spring Boot que proporciona un endpoint RESTful GET para demostrar el uso de las tecnologías siguientes:

- **Spring Boot:** Framework para construir aplicaciones Java basadas en Spring.
- **Spring Boot Starter Web:** Dependencia para crear aplicaciones web usando Spring MVC.
- **H2 Database:** Base de datos en memoria para desarrollo y pruebas.
- **Lombok:** Biblioteca que reduce la verbosidad del código Java.
- **Spring Boot Starter Data JPA:** Dependencia para la integración de JPA (Java Persistence API).

## Requisitos
- Java 17 o superior
- Maven 3.x

## Ejecución
1. Clona el repositorio disponible en [Github](https://github.com/franciscomesa/hexagonal-exercise) 
2. Abre una terminal y navega al directorio del proyecto.
3. Ejecuta la aplicación con Maven:
~~~ 
mvn spring-boot:run
~~~
4. La aplicación estará disponible en http://localhost:8080/

## Uso
Endpoint ```/api/ ```.

### Parámetros de la solicitud
- applicationDate (requerido): Fecha y hora de aplicación en formato ISO 8601 (ejemplo: "2021-10-06T14:30:00").
- productId (requerido): ID del producto (ejemplo: 1).
- brandId (requerido): ID de la marca (ejemplo: 123).

Ejemplo: http://localhost:8080/api?applicationDate=2020-06-15T21:00:00&productId=123&brandId=1

## Testing
- Se realizan dos grupos de tests demostrativos
  - Tests unitarios de la lógica de negocio
  - Tests de aceptación de la solución.


## Licencia
Este proyecto está bajo la licencia MIT License.