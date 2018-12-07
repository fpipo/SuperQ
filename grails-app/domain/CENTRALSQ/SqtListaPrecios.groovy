package CENTRALSQ

class SqtListaPrecios {
    String descripcionCorta
    int base
    String tipo
    int enviado

    static constraints = {
        descripcionCorta maxSize: 80, nullable: false
        tipo maxSize: 2, nullable: false
    }
}
