package CENTRALSQ

class SqtTicket {

    Date diaOperacion
    String tipo
    int enviado
    int idDetalle


    SqtVenta operacion
    SqtTienda tienda
    /*
    * SqtDetalle */

    static constraints = {

       operacion nullable: true
        tipo maxSize: 3
        diaOperacion nullable: true
        idDetalle nullable: true
        enviado nullable:true
    }
}
