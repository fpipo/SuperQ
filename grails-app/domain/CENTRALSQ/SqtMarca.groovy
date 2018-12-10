package CENTRALSQ

class SqtMarca {
    String descripcion
    int enviado

    static constraints = {
        descripcion maxSize: 50, nullable: false
    }
}
