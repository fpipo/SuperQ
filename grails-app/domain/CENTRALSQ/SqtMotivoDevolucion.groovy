package CENTRALSQ

class SqtMotivoDevolucion {
    String clave
    String descripcion
    int ocultar
    int enviado
    String origen

    static constraints = {
        clave maxSize: 3
        descripcion maxSize: 50
        origen maxSize: 10 , nullable: true
        ocultar nullable: true
        enviado nullable:true
    }
}
