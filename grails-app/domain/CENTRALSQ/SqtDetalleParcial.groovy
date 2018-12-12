package CENTRALSQ

class SqtDetalleParcial {

    Double cantidad
    Double precioCompraSiva
    Double ivaPrecioCompra
    Double subtotal
    Double iva
    Double total
    Date fechaAplicacion
    int impresion
    Double montoFs
    Double totalFactura
    String comentarios
    int enviado


    SqtPedido pedido
    SqtTienda tienda
    SqtProducto producto
    SqtFactura numFactura
    SqtTicket numRemision


    static constraints = {
        comentarios maxSize: 255
        enviado nullable:true
    }
}
