package CENTRALSQ

class SqtNuevoGrupo {

    String descripcion
    int enviado

    static constraints = {
        descripcion maxSize:50
        enviado nullable:true
    }
}
