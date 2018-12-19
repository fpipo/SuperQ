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
        costoPromedio nullable: true
        ivaCostoPromedio nullable: true
        ajusteCosto nullable: true
        ivaCosto nullable: true
        totalCosto nullable: true
        precioVentaSiva nullable: true
        montoivaPrecioVenta nullable: true
        precioVentaCiva nullable: true
        cobroPventaSiva nullable: true
        iva nullable: true
        total nullable: true
        impuesto nullable: true
        enviado nullable:true
        factura nullable: true
        poliza nullable: true
        conCargo nullable:true
        montoISB nullable: true

    }
}
