package CENTRALSQ

class SqtTipoCliente {
    String descripcion
    int enviado

    static constraints = {
        descripcion maxSize: 50, nullable: true
        enviado nullable:true
    }
}
