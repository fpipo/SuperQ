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
    Double margenUtilidad
    Double precioCompraSiva
    int enviado
    Double montoIsb

    SqtTienda tienda
    SqtProducto producto
    SqtUsuario usuarioAutorizacion
    SqtImpuesto impuesto
    SqtPoliza poliza

    static belongsTo = [traspasoP: SqtVenta]

    static constraints = {
        descuento nullable: true
        ivaDescuento nullable: true
        usuarioAutorizacion nullable: true
        impuesto nullable: true
        poliza nullable: true
        margenUtilidad nullable: true
        precioCompraSiva nullable: true
        enviado nullable:true
        montoIsb nullable: true
    }
}
