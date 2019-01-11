package CENTRALSQ

class SqtDetallePedido {
    int clavePol
    int partida
    Double cantidadSugerida
    Double precioCompraSiva
    Double subtotal
    Double iva
    Double total
    String codigoCaja
    String presentacion
    SqtArchivo archivo
    int enviado
    Date fechaAplicacion
    int impresion
    String numFactura
    String numRemision
    int numTransaccion
    Double totalFactura
    String comentarios

    SqtPoliza poliza
    SqtTienda tienda
    SqtProducto producto
    SqtImpuesto impuesto
    SqtUnidadMedida unidadMedida

    static  belongsTo = [pedido:SqtPedido]

    static constraints = {
        impresion nullable: true
        numFactura maxSize: 30, nullable: true
        numRemision maxSize: 30, nullable: true
        numTransaccion nullable: true
        totalFactura nullable: true
        comentarios maxSize: 255, nullable: true
        poliza nullable: true
        precioCompraSiva nullable: true
        subtotal nullable: true
        unidadMedida nullable: true
        presentacion maxSize: 10, nullable: true
        impuesto nullable: true
        enviado nullable:true
        archivo nullable: true
    }
}
