package CENTRALSQ

class SqtRedq {
    String id
    String plaza
    Date fechaAdmin
    Date fechaNatural
    String hora
    Double monto
    String idTarjeta
    String autorizacion
    String referencia
    int error
    Double saldo
    int enviado
    int enviadoRedQ
    SqtVenta venta
    SqtTienda tienda
    SqtCaja caja

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        plaza maxSize: 5
        idTarjeta maxSize: 20
        autorizacion maxSize: 30
        referencia maxSize: 50
    }
}
