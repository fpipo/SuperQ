package CENTRALSQ

class SqtGrupoGlasgo {
    String descripcion
    SqtEstatus estatus
    int enviado

    static constraints = {
        descripcion maxSize: 200
        enviado nullable:true
    }
}
