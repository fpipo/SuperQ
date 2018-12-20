package CENTRALSQ

class SqtCodigoProducto {
    int base
    String codigo
    int enviado

    SqtProducto producto

    static constraints = {
        codigo maxSize: 30
        enviado nullable:true
    }
}
