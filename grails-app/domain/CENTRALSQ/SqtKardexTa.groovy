package CENTRALSQ

class SqtKardexTa {

    String autcod
    String telefono
    Date fecha
    String hora
    int enviado
    String legal
    int ticket

    SqtKardex kardex
    SqtTienda tienda
    SqtProducto producto
    SqtMovimiento movimiento
    SqtTransaccion transaccion

    static constraints = {
        autcod maxSize: 50
        telefono maxSize: 20
        hora maxSize: 12
        enviado nullable:true
        legal maxSize: 255
    }
}
