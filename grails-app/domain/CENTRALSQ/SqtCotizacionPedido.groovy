package CENTRALSQ

class SqtCotizacionPedido {
    Double precioNormal
    Double precioNormalSiva
    Double precioOferta
    Double precioRegalo
    Double precioUnitario
    Date fechaMod
    int enviado

    SqtPedido pedido
    SqtTienda tienda
    SqtProveedor proveedor
    SqtProducto producto
    SqtUsuario usuarioMod

    static constraints = {
        enviado nullable:true
        precioNormal nullable: true
        precioNormalSiva nullable: true
        precioOferta nullable: true
        precioUnitario nullable: true
        precioRegalo nullable: true
    }
}
