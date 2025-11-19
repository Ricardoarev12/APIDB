# EJEMPLOS DE PETICIONES API

## ESTADOS

### GET - Listar todos los estados
curl -X GET http://localhost:8080/estados

### GET - Obtener un estado por ID
curl -X GET http://localhost:8080/estados/1

### POST - Crear un estado
curl -X POST http://localhost:8080/estados \
  -H "Content-Type: application/json" \
  -d '{"nombreEstado": "Nuevo Estado"}'

### PUT - Actualizar un estado
curl -X PUT http://localhost:8080/estados/1 \
  -H "Content-Type: application/json" \
  -d '{"nombreEstado": "Estado Actualizado"}'

### DELETE - Eliminar un estado
curl -X DELETE http://localhost:8080/estados/1

## MUNICIPIOS

### GET - Listar todos los municipios
curl -X GET http://localhost:8080/municipios

### GET - Obtener un municipio por ID
curl -X GET http://localhost:8080/municipios/1

### GET - Obtener municipios por estado
curl -X GET http://localhost:8080/municipios/estado/1

### POST - Crear un municipio
curl -X POST http://localhost:8080/municipios \
  -H "Content-Type: application/json" \
  -d '{
    "nombreMunicipio": "Nuevo Municipio",
    "estado": {"idEstado": 1}
  }'

### PUT - Actualizar un municipio
curl -X PUT http://localhost:8080/municipios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombreMunicipio": "Municipio Actualizado",
    "estado": {"idEstado": 1}
  }'

### DELETE - Eliminar un municipio
curl -X DELETE http://localhost:8080/municipios/1

## TIPOS DE MUSEO

### GET - Listar todos los tipos de museo
curl -X GET http://localhost:8080/tipos-museo

### GET - Obtener un tipo de museo por ID
curl -X GET http://localhost:8080/tipos-museo/1

### POST - Crear un tipo de museo
curl -X POST http://localhost:8080/tipos-museo \
  -H "Content-Type: application/json" \
  -d '{"nombreTipo": "Nuevo Tipo"}'

### PUT - Actualizar un tipo de museo
curl -X PUT http://localhost:8080/tipos-museo/1 \
  -H "Content-Type: application/json" \
  -d '{"nombreTipo": "Tipo Actualizado"}'

### DELETE - Eliminar un tipo de museo
curl -X DELETE http://localhost:8080/tipos-museo/1

## MUSEOS

### GET - Listar todos los museos
curl -X GET http://localhost:8080/museos

### GET - Buscar museos por nombre
curl -X GET "http://localhost:8080/museos?nombre=arte"

### GET - Obtener un museo por ID
curl -X GET http://localhost:8080/museos/1

### POST - Crear un museo
curl -X POST http://localhost:8080/museos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Museo Nuevo",
    "direccion": "Calle Principal 123",
    "municipio": {"idMunicipio": 1},
    "tipoMuseo": {"idTipoMuseo": 1},
    "codigoPostal": "12345",
    "telefono": "5551234567",
    "horario": "10:00 - 18:00"
  }'

### PUT - Actualizar un museo
curl -X PUT http://localhost:8080/museos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Museo Actualizado",
    "direccion": "Calle Nueva 456",
    "municipio": {"idMunicipio": 1},
    "tipoMuseo": {"idTipoMuseo": 2},
    "codigoPostal": "54321",
    "telefono": "5559876543",
    "horario": "09:00 - 17:00"
  }'

### DELETE - Eliminar un museo
curl -X DELETE http://localhost:8080/museos/1

## USUARIOS

### GET - Listar todos los usuarios
curl -X GET http://localhost:8080/usuarios

### GET - Obtener un usuario por ID
curl -X GET http://localhost:8080/usuarios/1

### POST - Crear un usuario
curl -X POST http://localhost:8080/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Usuario Nuevo",
    "correo": "usuario@example.com",
    "contrasena": "password123"
  }'

### PUT - Actualizar un usuario
curl -X PUT http://localhost:8080/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Usuario Actualizado",
    "correo": "usuario@example.com",
    "contrasena": "newpassword"
  }'

### DELETE - Eliminar un usuario
curl -X DELETE http://localhost:8080/usuarios/1

### POST - Login
curl -X POST http://localhost:8080/usuarios/login \
  -H "Content-Type: application/json" \
  -d '{
    "correo": "admin@museos.com",
    "contrasena": "admin123"
  }'

## COLECCIÓN POSTMAN

{
  "info": {
    "name": "API Museos",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Estados",
      "item": [
        {
          "name": "GET Estados",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/estados",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["estados"]
            }
          }
        }
      ]
    },
    {
      "name": "Municipios",
      "item": [
        {
          "name": "GET Municipios",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/municipios",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["municipios"]
            }
          }
        },
        {
          "name": "GET Municipios por Estado",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/municipios/estado/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["municipios", "estado", "1"]
            }
          }
        }
      ]
    },
    {
      "name": "Museos",
      "item": [
        {
          "name": "GET Museos",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/museos",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["museos"]
            }
          }
        },
        {
          "name": "GET Buscar Museo por Nombre",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/museos?nombre=arte",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["museos"],
              "query": [
                {
                  "key": "nombre",
                  "value": "arte"
                }
              ]
            }
          }
        },
        {
          "name": "POST Crear Museo",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"nombre\": \"Museo Nuevo\",\n  \"direccion\": \"Calle Principal 123\",\n  \"municipio\": {\"idMunicipio\": 1},\n  \"tipoMuseo\": {\"idTipoMuseo\": 1},\n  \"codigoPostal\": \"12345\",\n  \"telefono\": \"5551234567\",\n  \"horario\": \"10:00 - 18:00\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/museos",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["museos"]
            }
          }
        },
        {
          "name": "PUT Actualizar Museo",
          "request": {
            "method": "PUT",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"nombre\": \"Museo Actualizado\",\n  \"direccion\": \"Calle Nueva 456\",\n  \"municipio\": {\"idMunicipio\": 1},\n  \"tipoMuseo\": {\"idTipoMuseo\": 2},\n  \"codigoPostal\": \"54321\",\n  \"telefono\": \"5559876543\",\n  \"horario\": \"09:00 - 17:00\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/museos/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["museos", "1"]
            }
          }
        },
        {
          "name": "DELETE Eliminar Museo",
          "request": {
            "method": "DELETE",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/museos/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["museos", "1"]
            }
          }
        }
      ]
    },
    {
      "name": "Usuarios",
      "item": [
        {
          "name": "POST Login",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"correo\": \"admin@museos.com\",\n  \"contrasena\": \"admin123\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/usuarios/login",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["usuarios", "login"]
            }
          }
        }
      ]
    }
  ]
}
