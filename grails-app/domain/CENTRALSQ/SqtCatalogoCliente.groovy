package CENTRALSQ

class SqtCatalogoCliente {

    SqtCliente cliente
    SqtTienda tienda
    String nombre
    String futuro
    String rfc
    SqtTipo tipo
    SqtEstatus estatus
    Date fechaMod
    String usuarioMod
    int enviado
    SqtUsuario usuario

    static constraints = {
        nombre maxSize: 200
        futuro maxSize: 3 , nullable: true
        rfc maxSize: 20,nullable: true
        tienda nullable: true
        tipo nullable: true
        estatus nullable: true
        usuario nullable: true
        enviado nullable:true
        fechaMod nullable: true
    }
}
