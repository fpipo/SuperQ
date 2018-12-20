package CENTRALSQ

class SqtMunicipio {
    SqtEstado estado
    Date fechaCreacion
    Date fechaoMod
    SqtUsuario usuarioMod
    int enviado

    static constraints = {
        enviado nullable:true
    }
}
