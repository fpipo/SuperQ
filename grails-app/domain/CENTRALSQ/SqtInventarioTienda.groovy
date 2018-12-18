package CENTRALSQ

class SqtInventarioTienda {

    Double inventario
    Date fecha
    int enviado

    SqtTienda tienda

    static constraints = {
        fecha nullable:true
        inventario nullable:true
        enviado nullable:true
    }
}
