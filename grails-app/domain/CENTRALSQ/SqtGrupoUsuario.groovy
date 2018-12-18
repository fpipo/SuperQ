package CENTRALSQ

class SqtGrupoUsuario {
    String descripcionCorta
    String descripcionLarga
    Date fechaMod
    int enviado

    SqtEstatus  estatus

    static constraints = {
        descripcionCorta maxSize: 50
        descripcionLarga maxSize: 250, nullable:true
        enviado nullable:true
    }
}
