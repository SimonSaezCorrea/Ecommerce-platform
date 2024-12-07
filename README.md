# multitenant

- [multitenant](#multitenant)
  - [Introducción](#introducción)
  - [Instalación](#instalación)
  - [Uso](#uso)
  - [API](#api)

## Introducción

Este proyecto es una aplicación de ejemplo para mostrar cómo se puede implementar 
una arquitectura multitenant en una aplicación web.

La aplicación está desarrollada en Spring Boot y React. Además, se utiliza una 
base de datos PostgreSQL para almacenar los datos.

El contexto de la aplicación es en una plataforma escolar, donde se pueden
crear diferentes instituciones educativas (tenants) y cada una de ellas puede
tener sus propios cursos y estudiantes.

## Instalación

Para instalar la aplicación, primero clona el repositorio:

```bash
git clone https://github.com/SimonSaezCorrea/multitenant.git
```

Luego, instala las dependencias:

```bash
npm install
```

## Uso

Para iniciar la aplicación, ejecuta el siguiente comando:

```bash
npm start
```

## API

La aplicación cuenta con los siguientes endpoints:
