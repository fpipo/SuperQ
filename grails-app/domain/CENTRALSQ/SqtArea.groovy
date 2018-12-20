package CENTRALSQ

class SqtArea {
    String descripcion
    String centroCostos
    int enviado

    static constraints = {
        descripcion maxSize: 50, nullable: true
        centroCostos maxSize: 30, nullable: true
        enviado nullable: true
    }
}
