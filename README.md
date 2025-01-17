# API RESTful

Proyecto desarrollado en Spring Boot, para buscar noticias en el portal de noticias ABC, los formatos a descargar son estos:
- JSON
- XML
- HTML SIMPLE
- TEXTO PLANO      

## Funcionamiento

Este proyecto funciona bajo la estructura MVC de Spring Boot. Manejar solicitudes de búsqueda de noticias atravez de un link desde un frontend basico, hace una llamada a una API externa, procesa los datos recibidos y genera las respuestas adecuadas dependiendo del `Accept` enviado al seleccionar el formato (JSON, XML, HTML o TEXTO PLANO) para luego ser descargadas en el formato seleccionado:

- Las consultas y el `Accept` se procesan primeramente por medio de JavaScript. Dependiento del formato seleccionado al presionar el botón de descarga, se realiza una solicitud AJAX al servidor utilizando `XMLHttpRequest` y se establece el encabezado `Accept`. Cuando se procesa la solicitud y se manejan las respuestas exitosas y los errores correspondientes.

- La solictud es enviada primeramente al controlador de Spring MVC anotado con `@RestController`, lo que significa que se utilizará para manejar solicitudes REST. El método definido dentro del controlador se encarga de manejar la solicitud GET a la ruta `/consulta`. El parámetro de consulta `q` obtiene el campo de búsqueda en la solicitud. El controlador hace uso el servicio `newsService` para obtener las noticias mediante una llamada a la API externa. Dependiendo del resultado de la llamada al servicio, el controlador devuelve una respuesta adecuada con datos o mensajes de error.

- En el servicio se maneja el método `getNews`, donde se realiza una llamada a la API externa utilizando `RestTemplate`. Es aquí donde se contruye la URL de la API utilizando el parámetro de búsqueda recibido. Una vez procesados los datos, dependiendo del tipo de respuesta deseado y el encabezado `Accept` proporcionado, se generan las respuestas correspondientes. Si se produce un error, se generan mensajes de error y se devuelven como respuestas adecuadas.

## Pasos a seguir

Antes de clonar y ejecutar el proyecto, asegurate de cumplir con los requisitos, sigue los pasos a continuación:

En este caso yo use la version 21 del JDk de java para hacer mis pruebas y debes de descargar Maven yo use la version `3.9.8` (recomiendo misma version), despues puedes agregar al PATH de Windows y en el CMD verificar la version con un mvn -v, despues:

1. Clonar el repositorio.
2. Situarse en el directorio del proyecto.
3. Ejecutar `mvn clean install` (recomiendo esto primero para borrar el target que trae el git, lo limpia y compila el proyecto) y despues `mvn spring-boot:run` para iniciar la aplicación.
4. Abrir un navegador web y navegar a `http://localhost:8080`, se vera una UI sencilla y muy intuitiva.
5. Introducir la consulta en el campo de entrada y presionar el botón para procesar y descargar un archivo con el formato deseado.

## Base64

Se implementó la posibilidad de procesar las imágenes en base64 y su content-type, pero solo para el formato JSON, debido a los recursos utilizados al procesar la consulta.