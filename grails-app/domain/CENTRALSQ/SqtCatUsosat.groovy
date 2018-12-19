package CENTRALSQ

class SqtCatUsosat {
    String idUso
    String descripcion

    SqtEstatus estatus

    static constraints = {
        idUso maxSize: 3
        descripcion maxSize: 100
    }
}
