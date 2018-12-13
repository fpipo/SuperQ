package CENTRALSQ

class SqtDetalleVentaProducto {
    int partida
    Double precioNeto
    Double ivaNeto
    Double precioVenta
    Double cantidad
    Double iva
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
    SqtProducto producto, codigo
    SqtUsuario usuarioAutorizacion
    SqtImpuesto impuesto
    SqtPoliza poliza

    static belongsTo = [traspasoP: SqtVenta]

    static constraints = {
        enviado nullable:true
    }
}
