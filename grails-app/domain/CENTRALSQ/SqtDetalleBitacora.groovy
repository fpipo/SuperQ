package CENTRALSQ

class SqtDetalleBitacora {
    int operacion
    Double cantidad
    Double precioVenta
    Date fechaMod
    int enviado

    SqtUsuario usuarioMod
    SqtMovimiento movimiento
    SqtProducto producto
    SqtTienda tienda

    static belongsTo = [bitacora:SqtBitacora]

    static constraints = {
        precioVenta nullable: true
        cantidad nullable: true
        enviado nulluable: true
    }
}
