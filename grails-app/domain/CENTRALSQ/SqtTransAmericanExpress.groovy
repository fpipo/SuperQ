package CENTRALSQ

class SqtTransAmericanExpress {
    String afiliacion
    String idArchivo
    String fechaPago
    Double monto
    String tarjeta
    String codigoDeclinado
    String descripcionDeclinado
    String referecia
    String autorizacion

    static constraints = {
        autorizacion nullable:true
    }
}
