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
    SqtUsuario usuarioAutorizacion
    SqtUsuario usuarioMod
    SqtPoliza poliza
    SqtPoliza polizaMensual

    static constraints = {
        comentarios maxSize: 250
    }
}
