package CENTRALSQ

class SqtListaPrecios {

    String descripcionCorta
    int base
    String tipo
    int enviado

    static constraints = {
        descripcionCorta maxSize: 80, nullable: false
        base nullable: true
        tipo maxSize: 2, nullable: true
        enviado nullable:true
    }
}
