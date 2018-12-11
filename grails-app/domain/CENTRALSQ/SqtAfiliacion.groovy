package CENTRALSQ

class SqtAfiliacion {
    String numCaja
    int enviado


    SqtTienda tienda
    SqtCaja caja
    SqtBanco banco

    static constraints = {
        numCaja maxSize: 2
        enviado nullable:true

    }
}
