package CENTRALSQ

class SqtNuevaCategoria {

    String descripcion
    int enviado

    SqtCategoria categoria

    static constraints = {
    descripcion maxSize: 500
    enviado nullable:true
    }
}
