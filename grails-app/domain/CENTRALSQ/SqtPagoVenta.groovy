package CENTRALSQ

class SqtPagoVenta {
    Double monto
    int enviado
    String tarjeta
    int partida

    SqtTienda tienda
    SqtFormaPago formaPago
    SqtVenta venta

    static constraints = {
        tarjeta maxSize: 16
        enviado nullable:true
    }
}
