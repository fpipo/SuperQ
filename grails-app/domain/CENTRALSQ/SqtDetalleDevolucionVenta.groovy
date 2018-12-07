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
    Double montoFs
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

    static belongsTo = [ajuste:SqtDevolucionVenta]

    static constraints = {
    }
}
