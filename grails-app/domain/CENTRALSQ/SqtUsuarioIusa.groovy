package CENTRALSQ

class SqtUsuarioIusa {

    String password
    SqtUsuario usuario
    String tienda
    SqtTienda idtienda
    SqtEstatus estatus

    static constraints = {
        password maxSize: 20
        tienda maxSize: 20
    }
}
