# SWAGGER
Podrá visualizar la documentación de la API en la siguiente liga:
http://localhost:8080/v1/swagger-ui/index.html


## import.sql
En este archivo se encuentran los insert de sucursales, productos y usuarios, este último para la generación de token


## Autenticación JWT
POST http://localhost:8080/v1/auth

{
  "usuario": "user",
  "contrasena": "user123"
}


## Crea un servicio POST que guarde una Orden De Compra de la sucursal CDMX con los siguientes productos:
18156 – Esmeriladora angular - $625 y 17193 – Pala redonda- $100.50
POST http://localhost:8080/v1/ordenes/save

{
  "orden_id": 0,
  "nombre_sucursal": "CDMX",
  "productos": [
    {
    "producto_id": 1
  },
  {
    "producto_id": 2
  }
  ],
  "fecha": "26/02/2025 20:09:20"
}


## Crear servicio GET que Obtenga la Orden de Compra guardada en el punto 3
GET http://localhost:8080/v1/ordenes/1


## Crear Servicio PUT que actualice el Precio del Producto 17193 por $99.99
PUT http://localhost:8080/v1/productos/updatePriceByCode/17193

{
  "precio": 99
}


## Por medio de un aspecto implementa un log que mida el tiempo de la ejecución de cada servicio.
Se implemento el log en el directorio raíz del proyecto en la carpeta logs, el archivo se llama evaluacio