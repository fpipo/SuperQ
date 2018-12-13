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
    Double montoFs
    Double precioVentaCiva
    Double cobroPventaSiva
    Double iva
    Double total
    int ajustado
    int enviado
    Double montoIsb

    SqtTienda tienda
    SqtProducto producto
    SqtImpuesto impuesto


    static constraints = {
        enviado nullable:true

    }
}
