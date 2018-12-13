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

    SqtTienda tienda
    SqtProducto producto
    SqtImpuesto impuesto
    SqtUnidadMedida unidadMedida

    static  belongsTo = [pedido:SqtPedido]

    static constraints = {
        codigoCaja maxSize: 30
        presentacion maxSize: 10
        archivo maxSize: 30
        enviado nullable:true
    }
}
