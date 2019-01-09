package CENTRALSQ

class SqtTipoCliente {
    String clave
    String descripcion
    int enviado

    static constraints = {
        clave maxSize: 3
        descripcion maxSize: 50, nullable: true
        enviado nullable:true
    }
}
