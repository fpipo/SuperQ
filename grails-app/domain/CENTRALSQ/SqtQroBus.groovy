package CENTRALSQ

class SqtQroBus {
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
    int enviadoRedq
    SqtVenta venta
    SqtTienda tienda
    SqtCaja caja

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        fechaAdmin nullable: true
        fechaNatural nullable: true
        plaza maxSize: 5, nullable: false
        hora maxSize: 12, nullable: true
        tienda nullable: true
        idTarjeta maxSize: 20, nullable: false
        autorizacion maxSize: 30, nullable: false
        referencia maxSize: 50, nullable: false
        enviado nullable:true
        enviadoRedq nullable: true
    }
}
