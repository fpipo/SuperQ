package CENTRALSQ

class SqtMoneda {
    String descripcion
    int enviado


    static constraints = {
        descripcion maxSize: 30
        enviado nullable:true
    }
}
