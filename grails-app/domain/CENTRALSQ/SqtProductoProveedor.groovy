package CENTRALSQ

class SqtProductoProveedor {
    Date fechaMod
    SqtUsuario usuarioMod
    int enviado

    SqtGrupoTienda grupoTienda
    SqtProveedor proveedor
    SqtProducto producto
    SqtEstatus estatus


    static constraints = {
        status nullable: true
        fechaMod nullable: true
        usuarioMod nullable: true
        enviado nullable:true

    }
}
