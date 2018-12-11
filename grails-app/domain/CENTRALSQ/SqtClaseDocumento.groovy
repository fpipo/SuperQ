package CENTRALSQ

class SqtClaseDocumento {
    String clave
    String descripcion
    int enviado

    static constraints = {
        clave maxSize: 2, nullable: false
        descripcion maxSize: 50, nullable: false
        enviado nuluable: true
    }
}
