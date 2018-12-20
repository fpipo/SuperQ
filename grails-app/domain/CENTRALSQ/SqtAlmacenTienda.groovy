package CENTRALSQ

class SqtAlmacenTienda {
    int enviado

    SqtTienda tienda
    SqtAlmacen almacen

    static constraints = {
        enviado nullable: true
    }
}
