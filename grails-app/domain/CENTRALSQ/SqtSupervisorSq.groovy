package CENTRALSQ

class SqtSupervisorSq {
    String nombre
    SqtEstatus estatus

    static constraints = {
        nombre maxSize: 100
        estatus nullable:true
    }
}
