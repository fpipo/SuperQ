package CENTRALSQ

class SqtAutorizaMovimiento {
    SqtMovimiento movimiento
    SqtFuncion funcion
    SqtGrupoUsuario Grupo
    String enviado

    static constraints = {
        enviado nullable: true
    }
}
