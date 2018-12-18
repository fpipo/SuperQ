package CENTRALSQ

class SqtExistenciaTienda {
    Double existencia
    Double contenidoExistencia
    Double stockMaximo
    Double puntoReorden
    Double puntoRedondeo
    Double costoPromedio
    Double precioVentaSiva
    Double ivaCostoPromedio
    Double montoivaPrecioVenta
    Double saldo
    Double margenUtilidad
    int sugerido
    Double diferencia
    Date fechaMod
    int enviado
    int cambioStock

    SqtTienda tienda
    SqtAlmacen almacen
    SqtUsuario usuarioMod
    SqtProducto producto

    static constraints = {
        existencia nullable:true
        contenidoExistencia nullable:true
        stockMaximo nullable:true
        puntoReorden nullable:true
        puntoRedondeo nullable:true
        costoPromedio nullable:true
        precioVentaSiva nullable:true
        ivaCostoPromedio nullable:true
        montoivaPrecioVenta nullable:true
        saldo nullable:true
        margenUtilidad nullable:true
        sugerido nullable:true
        diferencia nullable:true
        producto nullable:true
        cambioStock nullable:true
        enviado nullable:true
    }
}
