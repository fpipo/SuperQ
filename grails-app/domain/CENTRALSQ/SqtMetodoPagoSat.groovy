package CENTRALSQ

class SqtMetodoPagoSat {

    String descripcion
    SqtEstatus estatus

    static constraints = {
        descripcion maxSize: 100
    }
}
