
# Proyecto de Gestión de Antigüedades

Este proyecto es una aplicación web desarrollada en **Spring Boot** para la gestión de antigüedades, permitiendo a los usuarios listar piezas antiguas para venta, y permitiendo a coleccionistas y otros interesados explorar y adquirir artículos. Incluye funciones de gestión de usuarios, inventario, transacciones, informes, entre otros.

## Características

- **Gestión de Usuarios**: Registros de empleados, clientes, y coleccionistas con distintos roles y privilegios.
- **Catálogo de Antigüedades**: Permite listar antigüedades por periodos y categorías, con información detallada sobre cada pieza.
- **Transacciones**: Procesamiento de compras y ventas de antigüedades, con control de inventario y stock.
- **Informes y Estadísticas**: Generación de informes sobre ventas, stock disponible, y otros datos relevantes.
- **Seguridad y Privacidad**: Implementación de autenticación y autorización utilizando **Spring Security**.

- ## Estructura de Carpetas

  Cada entidad en el proyecto sigue una estructura organizada en las siguientes capas:

  - controller

    : Contiene los controladores REST que gestionan las peticiones HTTP.

    - `AntiquityController`: Expone los endpoints para realizar las operaciones CRUD.

  - domain

    - repository

      : Contiene los repositorios que gestionan las operaciones de persistencia.

      - `AntiquityRepository`: Interfaz que extiende **JPA Repository** para interactuar con la base de datos.

    - service

      : Contiene la lógica de negocio y la implementación de los servicios.

      - `AntiquityImpl`: Implementación de la interfaz de servicio.
      - `IAntiquity`: Interfaz que define los métodos del servicio.

  - persistence

    : Contiene las entidades que representan las tablas en la base de datos.

    - `Antiquity`: Clase que mapea la entidad `Antiquity` con la tabla correspondiente en la base de datos.

  Esta misma estructura se sigue para todas las entidades del proyecto, como `collectionist`, `contactUser`, `period`, entre otras, garantizando una separación clara entre las responsabilidades de cada capa.

  ## Endpoints para CRUD de Entidades

  Cada entidad en el proyecto sigue una estructura de controladores REST para gestionar las operaciones CRUD. A continuación se describe la estructura común de los endpoints, utilizando la entidad `Antiquity` como ejemplo.

  ### Descripción de los Endpoints

  - **GET `/antiquity`**: Devuelve una lista con todas las antigüedades disponibles en el sistema.
  - **GET `/antiquity/{id}`**: Devuelve los detalles de una antigüedad específica, identificada por su ID.
  - **POST `/antiquity`**: Permite crear una nueva antigüedad en el sistema, recibiendo la información en el cuerpo de la solicitud.
  - **PUT `/antiquity/{id}`**: Actualiza la información de una antigüedad existente, identificada por su ID.
  - **DELETE `/antiquity/{id}`**: Elimina una antigüedad del sistema, identificada por su ID.
  - 

### Ejemplo de post a la entidad antiquity

- ```json
  {
      "name": "Xiaomi Poco",
      "description": "All bad",
      "price": 10000.00,
      "origin": "China", 
      "category": {"codeCategory": 1},
      "period": {"codePeriod": 1},
      "conservationStatus": {"codeStatus": 1},
      "availability": {"codeAvailability": 1},
      "branch": {"codeBranch": 2}
  }
  ```

  

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.0**
- **Spring Data JPA**
- **Spring Security**
- **MapStruct**
- **Lombok**
- **MySQL** como base de datos relacional
- **Maven** para la gestión de dependencias

## Instalación

1. Clona el repositorio:

   ```
   bash
   Copiar código
   git clone https://github.com/usuario/proyecto-antiguedades.git
   ```
   
2. Configura la base de datos en el archivo `application.properties` o `application.yml`:

   ```
   propertiesCopiar códigospring.datasource.url=jdbc:mysql://localhost:3306/antiguedades
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Ejecuta la aplicación desde tu IDE o desde la línea de comandos:

   ```
   bash
   Copiar código
   mvn spring-boot:run
   ```
   
4. Accede a la aplicación en `http://localhost:8080`.

## Base de Datos

- El proyecto contiene las siguientes tablas, y cada una de ellas cuenta con su propio CRUD (Create, Read, Update, Delete) implementado:

  - **contactUser**: Gestión de las direcciones asociadas a usuarios y antigüedades.
  - **antiquity**: Catálogo de antigüedades, donde se pueden registrar, modificar, consultar y eliminar piezas.
  - **availability**: Gestión de la disponibilidad de antigüedades.
  - **branch**: Información sobre las distintas sucursales o puntos de venta.
  - **category**: Clasificación de las antigüedades por categorías.
  - **city**: Gestión de las ciudades asociadas a direcciones y antigüedades.
  - **company**: Información de las empresas asociadas.
  - **conservation_status**: Estado de conservación de las antigüedades, con opciones de consulta y modificación.
  - **gender**: Información sobre los países asociados a las direcciones y antigüedades.
  - **gallery**: Gestión de galerías de imágenes asociadas a las antigüedades.
  - **period**: Información sobre los periodos históricos a los que pertenecen las antigüedades.
  - **region**: Gestión de las regiones geográficas relacionadas con las antigüedades.
  - **type_address**: Clasificación de los tipos de direcciones (Residencial, Comercial, etc.).
  - **collectionist**: Gestión de usuarios, con la capacidad de crear, modificar, consultar y eliminar registros.

  Cada tabla cuenta con su propio conjunto de servicios REST para realizar operaciones CRUD.

## Qué falta? 

- Terminar de hacer CRUDs para algunas entidades
- Clases DTO
- Implementar Spring Security