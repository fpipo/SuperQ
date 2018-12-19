package CENTRALSQ

class SqtDetalleBitacora {
    Double cantidad
    Double precioVenta
    Date fechaMod
    int enviado

    SqtUsuario usuarioMod
    SqtMovimiento movimiento

    static belongsTo = [bitacora:SqtBitacora]

    static constraints = {
        precioVenta nullable: true
        cantidad nullable: true
        enviado nulluable: true
    }
}
