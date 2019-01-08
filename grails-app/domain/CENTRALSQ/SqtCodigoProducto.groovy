package CENTRALSQ

class SqtCodigoProducto {
    String codigo
    int enviado

    SqtProducto base

    static belongsTo = [base:SqtProducto]

    static constraints = {
        codigo maxSize: 30
        enviado nullable:true
    }
}
