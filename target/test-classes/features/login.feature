# language: es

@Cucumber
Característica: Iniciar sesion en portal transporte

  Este feature se trata de iniciar sesion  en el portal de transporte.

  Esquema del escenario: Iniciar sesion con diferentes roles
    Dado Que <actor> entra al portal  de transporte
    Cuando <actor> inicia sesion con usuario: <nombreUsuario> y clave: <claveUsuario>
    Entonces <actor> deberia poder ver la pantalla principal de: <pantalla>

    Ejemplos:
      | Descripcion                                  | actor         | nombreUsuario | claveUsuario | pantalla                 |
      | Resultado con Usuario Administrador          | Administrador | yulymode      | Colombia1+   | Puntos de transporte     |
      | Resultado con Usuario Transportista          | Transportista | 12345         | 12345        | Hola Prueba Ajustes,     |
      | Resultado con Usuario Empresa Transportadora | Empresa       | 0987654321    | LyherWk      | Usuarios transportadores |


