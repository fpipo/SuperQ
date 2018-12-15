package CENTRALSQ

class SqtCatalogoSat {
    int claveProdSer
    String descripcion
    int enviado
    SqtEstatus estatus
    SqtGrupo grupo

    static constraints = {
        descripcion maxSize: 200
        enviado nullable:true

    }
}
