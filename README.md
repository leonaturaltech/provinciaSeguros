## Palazzo Leonardo leonardo.palazzo@naturalth.it

## Descripción

Enunciado del ejercicio en docs

## Notas

***Ver las notas*** del prouecto en la carpeta docs

## Requisitos

- **Java JDK 11+**
- **Maven 3.6+**

## Instalación

1. Configurar en el archivo propertie el api key del servicio

   ```
   accuweather.api.key =
   ```
3. Compila el proyecto:

   ```bash
   mvn clean install
   ```

## Ejecución

Después de compilar, ejecuta la aplicación:

```bash
mvn spring-boot:run
```

## Pruebas

Por geolocalización

`curl --location 'localhost:8080/weather/v1/cities/geoposition/search?q=-34.601769%2C-58.371371'`

Por código postal

`curl --location 'localhost:8080/weather/v1/postalcodes/search?q=1878'`
