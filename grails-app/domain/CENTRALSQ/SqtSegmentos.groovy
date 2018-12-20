package CENTRALSQ

class SqtSegmentos {
    String descripcion
    int enviado

    static constraints = {
        descripcion maxSize: 250
        enviado nullable:true
    }
}
