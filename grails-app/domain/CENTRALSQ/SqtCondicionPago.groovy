package CENTRALSQ

class SqtCondicionPago {
    String condicion
    String descripcion
    int enviado

    static constraints = {
        condicion maxSize: 10, nullable: true
        descripcion maxSize: 50, nullable: true
        enviado nullable: true
    }
}
