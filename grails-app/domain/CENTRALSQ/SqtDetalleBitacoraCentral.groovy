package CENTRALSQ

class SqtDetalleBitacoraCentral {

    /*
    SqtOperacion
    SqtLog log identicar de donde viene esta tabla
*/
    SqtTienda tienda
    SqtBitacora bitacora
    SqtMovimiento movimiento
    SqtUsuario usuarioMod
    String codigo
    Double cantidad
    Double precioVenta
    Date fechaMod
    int enviado

    static constraints = {
        enviado nullable:true
        codigo nullable:true
        cantidad nullable: true
        precioVenta nullable: true
    }
}
