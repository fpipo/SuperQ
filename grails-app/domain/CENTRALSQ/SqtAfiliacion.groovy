package CENTRALSQ

class SqtAfiliacion {
    int enviado

    SqtTienda tienda
    SqtCaja caja
    SqtEstatus estatus
    SqtBanco banco

    static constraints = {
        enviado nullable:true
    }
}
