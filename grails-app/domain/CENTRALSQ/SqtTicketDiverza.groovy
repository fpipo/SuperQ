package CENTRALSQ

class SqtTicketDiverza {

    String referenciaDiverza
    String tipo
    String archivo
    String batchId
    int error
    int  enviado
    String mensaje

    SqtTienda tienda
    SqtEstatus estatus

    static constraints = {

        referenciaDiverza maxSize: 500
        tipo maxSize: 3
        archivo maxSize: 500
        batchId maxSize: 500, nullable: true
        mensaje maxSize: 8000, nullable: true
        enviado nullable:true
        error nullable: true
        enviado nullable: true

    }
}
