package CENTRALSQ

class SqtAgenciaRemesas {
    String nombre
    SqtTienda tienda
    /*
    * SqtComercic idComercio
    * SqtAgencia idAgencia
    *
    *
    * necesito saber de donde vienen los id´s de estos campos
    * */

    static constraints = {
        nombre maxSize: 100
    }
}
