package CENTRALSQ

class SqtTipoRetiro {
    String clave
    String descripcion

    SqtEstatus estatus

    static constraints = {
        clave maxSize: 3
        descripcion maxSize: 100
    }
}
