package CENTRALSQ

class SqtCondicionPago {
    String descripcion
    int enviado

    static constraints = {
        descripcion maxSize: 50
        enviado nulluable: true
    }
}
