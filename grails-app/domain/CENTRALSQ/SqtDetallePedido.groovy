package CENTRALSQ

class SqtDetallePedido {
    Double cantidadSugerida
    Double precioCompraSiva
    Double subTotal
    Double iva
    Double total
    String codigoCaja
    String presentacion
    String archivo
    Double montoFs
    int enviado

    SqtPedido pedido
    SqtTienda tienda
    SqtProducto producto
    SqtImpuesto impuesto
    SqtUnidadMedida unidadMedida

    static  belongsTo = [pedido:SqtPedido]

    static constraints = {
        precioCompraSiva nullable: true
        subTotal nullable: true
        unidadMedida nullable: true
        codigoCaja maxSize: 30, nullable: true
        presentacion maxSize: 10, nullable: true
        archivo maxSize: 30, nullable: true
        montoFs nullable: true
        impuesto nullable: true
        enviado nullable:true
    }
}
