package CENTRALSQ

class SqtDetalleBitacoraCentral {

    /*
    SqtOperacion
    SqtLog log identicar de donde viene esta tabla
*/
    SqtTienda tienda
    SqtBitacora bitacora
    SqtMovimiento movimiento
    String codigo
    Double cantidad
    Double precioVenta
    Date fechaMod
    String usuarioMod
    int enviado

    static constraints = {
        usuarioMod maxSize: 15
        enviado nullable:true
        codigo nullable:true
        cantidad nullable: true
        precioVenta nullable: true
    }
}
