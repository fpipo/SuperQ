package CENTRALSQ

class SqtTipoSku {
    String descripcion
    Date fechaCreacion
    Date fechaMod
    String usuarioMod
    int enviado

    static constraints = {
        enviado nullable:true
    }
}
