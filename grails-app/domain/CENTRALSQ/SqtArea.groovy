package CENTRALSQ

class SqtArea {
    String clave
    String descripcion
    String centroCostos
    int enviado

    static constraints = {
        clave maxSize: 3
        descripcion maxSize: 50, nullable: true
        centroCostos maxSize: 30, nullable: true
        enviado nullable: true
    }
}
