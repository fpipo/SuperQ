package CENTRALSQ

class SqtCotizacionPedido {
    Double precioNormal
    Double precioNormalSiva
    Double precioOferta
    Double precioRegalo
    Double precioUnitario
    Date fechaMod
    SqtPedido pedido
    SqtTienda tienda
    SqtProveedor proveedor
    SqtProducto producto
    SqtUsuario usuarioMod
    int enviado

    static constraints = {

        enviado nullable:true

    }
}
