package CENTRALSQ

class SqtBitacoraCentral {

    Date fecha
    String usuario

    SqtBitacora bitacora
    SqtTienda tienda
    SqtTransaccion transaccion

    static constraints = {
        usuario maxSize: 15
    }
}
