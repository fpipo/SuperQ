package CENTRALSQ

class SqtAfiliacionAmerican {
    SqtTienda tienda
    SqtAfiliacion afiliacion
    SqtBanco banco
    int enviado

    static constraints = {
        afiliacion nullable: true
        enviado nullable:true
    }
}
