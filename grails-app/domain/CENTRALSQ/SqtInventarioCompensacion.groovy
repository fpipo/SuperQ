package CENTRALSQ

class SqtInventarioCompensacion {

    Double existenciaTeorica
    Double existenciaFisica
    Double diferencia
    Double costoPromedio
    Double ivaCostoPromedio
    Double ajusteCosto
    Double ivaCosto
    Double totalCosto
    Double precioVentaSiva
    Double ivaPrecioVenta
    Double precioVentaCiva
    Double cobroPventaSiva
    Double iva
    Double total
    int ajustado
    int enviado
    Double montoIsb

    SqtInventario inventario
    SqtTienda tienda
    SqtProducto producto
    SqtImpuesto impuesto

    static constraints = {
        existenciaTeorica nullable:true
        existenciaFisica nullable:true
        diferencia nullable:true
        costoPromedio nullable:true
        ivaCostoPromedio nullable:true
        ajusteCosto nullable:true
        ivaCosto nullable:true
        totalCosto nullable:true
        precioVentaSiva nullable:true
        ivaPrecioVenta nullable:true
        precioVentaCiva nullable:true
        cobroPventaSiva nullable:true
        iva nullable:true
        total nullable:true
        ajustado nullable:true
        impuesto nullable:true
        enviado nullable:true
        montoIsb nullable:true
    }
}
