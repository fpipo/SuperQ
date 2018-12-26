package CENTRALSQ

class SqtMensajesTicket {
    String descripcion
    String posicion
    int orden

    SqtEstatus estatus

    static constraints = {
        descripcion maxSize: 250, nullable: true
        posicion maxSize: 50, nullable: true
    }
}
