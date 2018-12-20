package CENTRALSQ

class SqtTipo {
    String clave
    String descripcion
    String tipo
    int proveedor
    int enviado

    static constraints = {
        clave maxSize: 4
        descripcion maxSize: 50, nullable: false
        tipo maxSize: 2
        proveedor nullable: true
        enviado nullable:true
    }
}
