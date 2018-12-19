package CENTRALSQ

class SqtCatalagoCliente {

    SqtCliente cliente
    SqtTienda tienda
    String nombre
    String futuro
    String enviado
    String rfc

    SqtTipo tipo
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static constraints = {
        nombre maxSize: 200
        futuro maxSize: 3, nullable: true
        rfc maxSize: 13, nullable: true
        usuarioMod nullable: true
        enviado nullable: true
    }
}
