package CENTRALSQ

class SqtDetalleAjuste {
    int partida
    Double cantidad
    Double costoPromedio
    Double ivaCostoPromedio
    Double ajusteCosto
    Double ivaCosto
    Double totalCosto
    Double precioVentaSiva
    Double montoivaPrecioVenta
    Double montoFS
    Double precioVentaCiva
    Double cobroPventaSiva
    Double iva
    Double total
    int conCargo
    int enviado
    Double montoISB

    SqtTienda tienda
    SqtProducto producto
    SqtMovimiento movimiento
    SqtImpuesto impuesto
    SqtFactura factura
    SqtPoliza poliza

    static belongsTo = [ajuste:SqtAjuste]

    static constraints = {
        enviado nullable:true
    }
}
