package CENTRALSQ

class SqtKardex {
    String id
    Date fecha
    String hora
    Double existenciaInical
    Double cantidad
    Double existenciaFinal
    String comentarios
    Double costoPromedio
    Double ivaCostoPromedio
    Double costoInicial
    Double saldo
    Double precioVentaSiva
    Double montoIvaPrecioVenta
    Double montoFs
    Double margenUtilidad
    SqtUsuario usuarioMod
    Date fechaMod
    int enviado
    Double montoIbs
    Double precioVentaSivaComp

    SqtTienda tienda
    SqtProducto producto
    SqtMovimiento movimiento
    SqtArea area
    SqtPoliza poliza
    SqtFactura factura
    SqtImpuesto impuesto


    static mapping = {
        id generator: 'uuid', name:'id'
    }


    static constraints = {
    }
}
