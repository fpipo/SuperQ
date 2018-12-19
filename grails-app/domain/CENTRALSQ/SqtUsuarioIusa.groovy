package CENTRALSQ

class SqtUsuarioIusa {
    String password
    int enviado
    String claveTienda

    SqtUsuario usuario
    SqtTienda tienda
    SqtEstatus estatus

    static constraints = {
        password maxSize: 20
        claveTienda maxSize: 20
        enviado nullable: true
    }
}
