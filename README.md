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

Instalación de las bases de datos:

1. Instala PostgreSQL en tu máquina.
2. Crea las base de datos:
   1. Crea una base de datos llamada `host` (Obligatorio).
   2. Crea una base de datos llamada `multitenant-0` (Obligatorio).
   3. Crea una base de datos llamada `school1`.
   4. Crea una base de datos llamada `school2`.
   5. O más dependiendo de la necesidad.
3. Ejecuta el script `create-tables.sql` en cada una de las bases de datos.
   1. Ejecuta el script en la base de datos `host`.
      * Debe conteneder:
        * `school` (id, name, tenant)
   2. Ejecuta el script en la base de datos `multitenant-0`.
      * Debe contener:
        * `datasourceconfig` (id, name, url, username, password, driverclassname, initialize)
        * `course` (id, description, id_professor, id_school, name)
        * `professor` (id, name, email)
        * `student` (id, name, email, id_course)
   3. Ejecuta el script en la base de datos `school1`.
      * Debe contener:
         * `course` (id, description, id_professor, id_school, name)
         * `professor` (id, name, email)
         * `student` (id, name, email, id_course)
   4. Ejecuta el script en la base de datos `school2`.
      * Debe contener:
         * `course` (id, description, id_professor, id_school, name)
         * `professor` (id, name, email)
         * `student` (id, name, email, id_course)
4. Ejecuta el script para insertar datos.
5. Modifica el archivo `application.properties` en el proyecto backend con los
   datos de tu base de datos.

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

#
#

Además hay que considerar que para hacer una peticion GET, POST, PUT o DELETE, 
se debe colocar un parametro especial en la URL, el cual es el schemaName.

Es decir las peticiones deben ser de la siguiente forma:

```
GET http://localhost:8080/course/getall?schemaName=<Nombre del Schema entre comillas>
```

```
GET http://localhost:8080/course/getall?schemaName="school1"
```



---
## Creditos

Este proyecto fue desarrollado por Simón Sáez Correa.

La información recopilada para elaborar la demo fue obtenida del creador 
**Coding World**, en su video ***Create multi tenant microservice using 
Springboot, Hibernate and Postgres***.

El video se encuentra en el siguiente enlace: 
[Create multi tenant microservice using Springboot, Hibernate and Postgres](https://www.youtube.com/watch?v=4jqfbiEXUtI)

