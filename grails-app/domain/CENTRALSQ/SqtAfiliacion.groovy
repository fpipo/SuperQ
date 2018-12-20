package CENTRALSQ

class SqtAfiliacion {
    String afiliacion
    String numCaja
    int enviado

    SqtTienda tienda
    SqtCaja caja
    SqtBanco banco
    SqtEstatus estatus

    static constraints = {
        afiliacion maxSize: 50
        numCaja maxSize: 2
        enviado nullable:true
        estatus nullable: true
    }
}
