package CENTRALSQ

class SqtAfiliacion {
    String afiliacion
    String numCaja
    int enviado

    SqtTienda tienda
    SqtBanco banco
    SqtEstatus estatus

    static constraints = {
        afiliacion maxSize: 50
        num: 2
        enviado nullable:true
        estatus nullable: true
    }
}
