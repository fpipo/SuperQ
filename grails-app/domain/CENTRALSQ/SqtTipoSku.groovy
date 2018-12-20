package CENTRALSQ

class SqtTipoSku {
    String descripcion
    Date fechaCreacion
    Date fechaMod
    SqtUsuario usuarioMod
    int enviado

    static constraints = {
        enviado nullable:true
    }
}
