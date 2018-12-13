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
    SqtProducto producto, codigo

    static constraints = {
        enviado nullable:true
        codigo maxSize: 30
    }
}
