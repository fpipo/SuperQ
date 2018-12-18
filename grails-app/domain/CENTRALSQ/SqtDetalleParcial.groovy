package CENTRALSQ

class SqtDetalleParcial {
    int partida
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
    SqtPoliza poliza
    SqtImpuesto impuesto

    static  belongsTo = [pedido:SqtPedido]

    static constraints = {
        precioCompraSiva nullable: true
        ivaPrecioCompra nullable: true
        impresion nullable: true
        numFactura nullable: true
        numRemision nullable: true
        poliza nullable: true
        montoFs nullable: true
        impuesto nullable: true
        totalFactura nullable: true
        comentarios maxSize: 255
        enviado nullable:true
    }
}
