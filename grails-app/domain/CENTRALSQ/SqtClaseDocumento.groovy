package CENTRALSQ

class SqtClaseDocumento {
    String clave
    String descripcion
    int enviado

    static constraints = {
        clave maxSize: 2
        descripcion maxSize: 50, nullable: true
        enviado nullable: true
    }
}
