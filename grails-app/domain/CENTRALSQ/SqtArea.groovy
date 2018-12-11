package CENTRALSQ

class SqtArea {
    String descripcion
    String centroCostos
    int enviado

    static constraints = {
        descripcion maxSize: 50
        centroCostos maxSize: 30
        enviado nullable: true
    }
}
