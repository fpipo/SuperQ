package CENTRALSQ

class SqtTiendaTipoVenta {
    String tipoventa
    int cambioPrecios
    int enviado
    SqtTienda tienda

    static constraints = {
        tipoventa maxSize: 3
        enviado nullable:true
    }
}
