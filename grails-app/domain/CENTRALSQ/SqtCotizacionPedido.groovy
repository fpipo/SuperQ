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
    }
}
