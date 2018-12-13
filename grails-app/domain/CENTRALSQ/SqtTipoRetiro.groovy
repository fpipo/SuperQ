package CENTRALSQ

class SqtTipoRetiro {
    String descripcion

    SqtEstatus estatus

    static constraints = {

        descripcion maxSize: 50

    }
}
