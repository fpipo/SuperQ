package CENTRALSQ

class SqtDetalleBitacoraCentral {

    /*
    SqtOperacion
    SqtLog log identicar de donde viene esta tabla
*/
    SqtTienda tienda
    SqtBitacora bitacora
    SqtMovimiento movimiento

    Double can
    Double precioVenta
    Date fechaMod
    String usuarioMod

    static constraints = {
        usuarioMod maxSize: 15
    }
}
