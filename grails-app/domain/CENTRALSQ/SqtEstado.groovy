package CENTRALSQ

class SqtEstado {
    String edo
    String descripcion
    int enviado

    SqtPais pais

    static constraints = {
        edo maxSize: 3
        enviado nullable: true
    }
}
