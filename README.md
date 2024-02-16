# user
API REST Servicio de User

Se declara los curl para la prueba a continuacion:

## Realizar una solicitud PUT

### Crear usuarios.

```bash
curl --location --request PUT 'http://localhost:8080/user/register' \
--header 'Content-Type: application/json; charset=UTF-8' \
--data-raw '{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "Hunter02",
    "phones": [
      {
        "number": "1234567",
        "citycode": "1",
        "contrycode": "57"
      }
    ]
  }'
```
