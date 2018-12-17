package CENTRALSQ

class SqtUsuarioGrupoUsuario {
    SqtUsuario usuario
    SqtGrupoUsuario grupoUsuario
    int principal
    int enviado

    static constraints = {
        principal nullable: true
        enviado nullable: true
    }
}
