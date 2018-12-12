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
    SqtUsuario usuarioMod
    int enviado
    int cambioStock

    SqtAlmacen almacen
    SqtProducto producto

    static constraints = {
        enviado nullable:true

    }
}
