package CENTRALSQ

class SqtImpuestoListaPrecios {
    Double valor
    int enviado
    SqtImpuesto impuesto
    SqtListaPrecios listaPrecios

    static constraints = {
        enviado nullable:true
    }
}
