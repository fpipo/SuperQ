package CENTRALSQ

class SqtProveedorLibreCompra {
    SqtEstatus estatus
    String comentarios
    Date fechaMod
    SqtUsuario usuarioMod
    int enviado

    SqtProveedor proveedor

    static constraints = {
        comentarios maxSize: 255, nullable: true
        fechaMod nullable: true
        usuarioMod nullable: true
        enviado nullable: true
    }
}
