## Información sobre la base de datos en memoria

La base de datos en memoria puede visualizarse a través del siguiente enlace: [H2 Console](http://localhost:8080/h2-console)

- **Usuario**: `sa`
- **Contraseña**: `password`

## Consideraciones y decisiones tomadas

Dado que el enunciado contiene algunas ambigüedades y no se tuvo la oportunidad de aclararlas, se tomaron las siguientes decisiones:

- Los datos básicos se almacenan en una entidad/tabla simple llamada **`LocationWeather`**.
- Los datos de la respuesta de la API fueron simplificados en el DTO **`WeatherResponseDTO`**.
- AccuWeather proporciona múltiples APIs; se limitó la integración a las búsquedas por **geolocalización** y **código postal**.
- Debido a que no se especificó claramente el propósito de almacenar los datos en la base de datos, se decidió usarlos a modo de **auditoría**.
- Si el objetivo fuese implementar una **caché** en la base de datos, se recomienda utilizar un sistema como **Spring Cache**.
- Se implementaron pruebas básicas como ejemplos.

## Detalles sobre la solución

- Respetando la interfaz **`WeatherServiceProvider`**, es posible modificar la implementación para cualquier otro proveedor de servicios meteorológicos.
- **`WeatherResponseDTO`** representa el resultado de la API.
- **`LocationWeather`** es la entidad que se almacena en la base de datos.
