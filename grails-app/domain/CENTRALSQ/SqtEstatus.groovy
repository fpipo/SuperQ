package CENTRALSQ

class SqtEstatus {
    String clave
    String descripcion
    int visible
    int enviado

    static constraints = {
        clave maxSize: 3
        descripcion maxSize: 50
        visible nullable: true
        enviado nulluable: true
    }
}
