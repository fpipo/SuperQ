package CENTRALSQ

class SqtPoliza {
    String id
    Date fechaDocumento
    String sociedad
    Date fechaContabilizacion
    String periodo
    String comentarios
    Date fechaMod
    int enviado
    SqtUsuario usuarioMod
    SqtMovimiento movimiento
    SqtTienda tienda
    SqtMoneda moneda


    static hasMany = [detalles:SqtDetallePoliza]

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        sociedad maxSize: 4, nullable: false
        periodo maxSize: 2, nullable: false
        comentarios maxSize: 250
        enviado nullable:true
        moneda nullable:true
    }
}
