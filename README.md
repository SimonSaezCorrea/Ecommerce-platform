# Proyecto para implementar una arquitectura multitenant en una aplicación web

## Tabla de Contenidos

- [Multitenant](#multitenant)
  - [Introducción](#introducción)
  - [Instalación](#instalación)
  - [Uso](#uso)
  - [Creditos](#creditos)

---

## Introducción

Este proyecto es una aplicación de ejemplo para mostrar cómo se puede implementar 
una arquitectura multitenant en una aplicación web.

La aplicación está desarrollada en Spring Boot y React. Además, se utiliza una 
base de datos PostgreSQL para almacenar los datos.

El contexto de la aplicación es en una plataforma escolar, donde se pueden
crear diferentes instituciones educativas (tenants) y cada una de ellas puede
tener sus propios cursos y estudiantes.

---

## Instalación

Instala las dependencias del frontend para su correcto funcionamiento con:

```bash
npm install
```

---

## Uso

Para iniciar la aplicación, ejecuta el siguiente comando en la raíz del 
proyecto frontend:

```bash
npm start
```

Para iniciar el backend, ejecuta el siguiente comando en la raíz del
proyecto backend:

```bash
mvn spring-boot:run
```
O bien, puedes ejecutar el proyecto desde tu IDE de preferencia.

Para acceder a la aplicación, abre tu navegador y escribe la siguiente URL:

```
http://localhost:3000
```


Si quieres hacer testing mediante software de pruebas como Postman, puedes
utilizar la siguiente URL para acceder a los endpoints de la API:

```
http://localhost:8080
```

Es importante mencionar que la aplicación requiere de Headers específicos para
acceder a la información al ser una aplicación multitenant. Por lo tanto,
debes incluir el siguiente Header en tus peticiones:

```
X-TenantID: <tenant-name>
Content-Type: application/json
```

* Por ejemplo si quieres acceder a los cursos:

  ```
  GET http://localhost:8080/courses
  ```

  De una institución llamada "school1" debes incluir el siguiente Header en 
  tus peticiones (Si no lo añades, no podrás acceder a la información):

  ```
  X-TenantID: school1
  Content-Type: application/json
  ```

Considerar que el multitenant es solo para el proyecto multitenant, por lo que
acceder al proyecto schoolar no requiere de estos headers. Este funciona como
el inquilino principal, idealmente suele ser parte del login.


---
## Creditos

Este proyecto fue desarrollado por Simón Sáez Correa.

La información recopilada para elaborar la demo fue obtenida del creador 
**Coding World**, en su video ***Create multi tenant microservice using 
Springboot, Hibernate and Postgres***.

El video se encuentra en el siguiente enlace: 
[Create multi tenant microservice using Springboot, Hibernate and Postgres](https://www.youtube.com/watch?v=4jqfbiEXUtI)

