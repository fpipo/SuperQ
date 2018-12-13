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
    Date fechamod
    int enviado
    Double montoSiniva

    SqtTienda tienda
    SqtVenta venta
    SqtServicio servicio
    SqtEstatus estatus
    SqtUsuario usuarioMod
    SqtPoliza poliza, polizaMensual

    static belongsTo = [traspasoS: SqtVenta]

    static constraints = {
        contrato maxSize: 30
        periodoPago maxSize: 10, nullable: true
        ticket maxSize: 2, nullable: true
        comentarios maxSize: 250
        enviado nullable:true
    }
}
