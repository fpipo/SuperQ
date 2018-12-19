package CENTRALSQ

class SqtDetalleDevolucionVenta {

    int partida
    Double precioNeto
    Double ivaNeto
    Double precioVenta
    Double iva
    Double cantidad
    Double subtotal
    Double total
    Double descuento
    Double ivaDescuento
    Double margenUtilidad
    Double precioCompraSiva
    int enviado
    Double montoIsb

    SqtTienda tienda
    SqtProducto producto
    SqtProducto codigo
    SqtMotivoDevolucion motivoDevolucion
    SqtImpuesto impuesto
    SqtPoliza poliza

    static belongsTo = [devolucion:SqtDevolucionVenta]

    static constraints = {
        descuento nullable: true
        ivaDescuento nullable: true
        margenUtilidad nullable: true
        precioCompraSiva nullable: true
        montoIsb nullable: true
        enviado nullable:true
    }
}
