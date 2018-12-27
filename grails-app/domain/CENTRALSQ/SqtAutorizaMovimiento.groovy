package CENTRALSQ

class SqtAutorizaMovimiento {
    SqtMovimiento movimiento
    SqtFuncion funcion
    SqtGrupoUsuario grupo
    int enviado

    static constraints = {
        enviado nullable: true
    }
}
