package CENTRALSQ

class SqtPagoVenta {
    Double monto
    int enviado
    String tarjeta
    int partida
    SqtTienda tienda
    SqtFormaPago formaPago


    static constraints = {
        tarjeta maxSize: 16, nullable: 16
    }
}
