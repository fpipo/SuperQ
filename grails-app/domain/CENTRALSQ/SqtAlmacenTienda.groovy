package CENTRALSQ

class SqtAlmacenTienda {
    int enviado
    SqtAlmacen almacen

    static belongsTo = [tienda:SqtTienda]

    static constraints = {
        enviado nullable: true
    }
}
