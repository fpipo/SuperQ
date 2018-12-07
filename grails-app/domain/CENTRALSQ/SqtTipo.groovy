package CENTRALSQ

class SqtTipo {
    String clave
    String descripcion
    String tipo
    int proveedor
    int enviado

    static constraints = {
        descripcion maxSize: 50, nullable: false
        tipo maxSize: 2, nullable: true
    }
}
