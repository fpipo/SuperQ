package CENTRALSQ

class SqtTipo {
    String clave
    String descripcion
    String tipo
    int proveedor
    int enviado

    static constraints = {
        descripcion maxSize: 50
        tipo maxSize: 2
    }
}
