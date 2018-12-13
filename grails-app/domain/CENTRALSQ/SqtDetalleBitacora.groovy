package CENTRALSQ

class SqtDetalleBitacora {
    Double cantidad
    Double precioVenta
    Date fechamod
    int enviado

    SqtUsuario usuarioMod
    SqtMovimiento movimiento

    static belongsTo = [bitacora:SqtBitacora]

    static constraints = {
        enviado nulluable: true
    }
}
