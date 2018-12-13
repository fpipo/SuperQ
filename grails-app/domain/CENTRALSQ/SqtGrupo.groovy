package CENTRALSQ

class SqtGrupo {
    String descripcion
    int enviado


    SqtCategoria categoria

    static constraints = {
        descripcion maxSize: 50
        enviado nullable:true

    }
}
