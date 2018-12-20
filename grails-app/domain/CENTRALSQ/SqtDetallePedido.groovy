package CENTRALSQ

class SqtDetallePedido {
    Double cantidadSugerida
    Double precioCompraSiva
    Double subtotal
    Double iva
    Double total
    String codigoCaja
    String presentacion
    SqtArchivo archivo
    int enviado

    SqtTienda tienda
    SqtProducto producto
    SqtImpuesto impuesto
    SqtUnidadMedida unidadMedida

    static  belongsTo = [pedido:SqtPedido]

    static constraints = {
        precioCompraSiva nullable: true
        subtotal nullable: true
        unidadMedida nullable: true
        codigoCaja maxSize: 30, nullable: true
        presentacion maxSize: 10, nullable: true
        impuesto nullable: true
        enviado nullable:true
        archivo nullable: true
    }
}
