package CENTRALSQ

class SqtKardex {
    String id
    Date fecha
    Double existenciaInical
    Double cantidad
    Double existenciaFinal
    int referencia
    String comentarios
    Double costoPromedio
    Double ivaCostoPromedio
    Double costoInicial
    Double saldo
    Double precioVentaSiva
    Double montoIvaPrecioVenta
    Double margenUtilidad
    Date fechaMod
    int enviado
    Double montoIsb
    Double precioVentaSivaComp

    SqtTienda tienda
    SqtProducto producto
    SqtMovimiento movimiento
    SqtArea area
    SqtPoliza poliza
    SqtFactura factura
    SqtImpuesto impuesto
    SqtUsuario usuarioMod

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        existenciaInical nullable:true
        cantidad nullable:true
        existenciaFinal nullable:true
        referencia nullable:true
        area nullable:true
        costoPromedio nullable:true
        ivaCostoPromedio nullable:true
        costoInicial nullable:true
        saldo nullable:true
        precioVentaSiva nullable:true
        montoIvaPrecioVenta nullable:true
        factura nullable:true
        impuesto nullable:true
        poliza nullable:true
        margenUtilidad nullable:true
        comentarios maxSize: 1000
        enviado nullable:true
        montoIsb nullable:true
        precioVentaSivaComp nullable: true
    }
}
