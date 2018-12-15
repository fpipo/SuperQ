package CENTRALSQ

class SqtMunicipio {
    SqtEstado estado
    Date fechaCreacion
    Date fechaoMod
    String usuarioMod
    int enviado

    static constraints = {


        usuarioMod maxSize:50
        enviado nullable:true

    }
}
