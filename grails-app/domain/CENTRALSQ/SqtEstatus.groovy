package CENTRALSQ

class SqtEstatus {
    String clave
    String descripcion
    int visible
    int enviado

    static constraints = {
        clave maxSize: 3, nullable: false
        descripcion maxSize: 50, nullable: false
    }
}
