package CENTRALSQ

class SqtTicket {

    Date diaOperacion
    String tipo
    int enviado


    SqtVenta operacion
    SqtTienda tienda
    /*
    * SqtDetalle */

    static constraints = {
        tipo maxSize: 3
        enviado nullable:true
    }
}
