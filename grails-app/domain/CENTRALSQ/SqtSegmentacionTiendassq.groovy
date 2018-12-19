package CENTRALSQ

class SqtSegmentacionTiendassq {
    String descripcion
    SqtEstatus estatus

    static constraints = {

        descripcion maxSize: 250
    }
}
