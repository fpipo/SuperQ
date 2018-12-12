package CENTRALSQ

class SqtInventarioTienda {

    Double inventario
    Date fecha
    int enviado

    SqtTienda tienda

    static constraints = {
        enviado nullable:true

    }
}
