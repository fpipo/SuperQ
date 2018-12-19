package CENTRALSQ

class SqtMoneda {
    String moneda
    String descripcion
    int enviado

    static constraints = {
        moneda maxSize: 3
        descripcion maxSize: 30
        enviado nullable:true
    }
}
