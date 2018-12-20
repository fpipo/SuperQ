package CENTRALSQ

class SqtDetalleVentaServicio {
    String contrato
    String periodoPago
    Double monto
    String ticket
    Date fechaVencimiento
    Double comision
    int montoEditable
    int fechaEditable
    String comentarios
    Date fechaMod
    int enviado
    Double montoSiniva

    SqtTienda tienda
    SqtVenta venta
    SqtServicio servicio
    SqtEstatus estatus
    SqtUsuario usuarioMod
    SqtPoliza poliza

    static belongsTo = [ventaS: SqtVenta]

    static constraints = {
        contrato maxSize: 30
        periodoPago maxSize: 10, nullable: true
        ticket maxSize: 2, nullable: true
        fechaVencimiento nullable: true
        comision nullable: true
        fechaEditable nullable: true
        montoEditable nullable: true
        comentarios maxSize: 250, nullable: true
        usuarioMod nullable: true
        fechaMod nullable: true
        enviado nullable:true
        montoSiniva nullable: true
    }
}
