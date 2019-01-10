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
    SqtEstatus estatus

    static hasMany = [detalles:SqtDetallePoliza]

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        sociedad maxSize: 4
        periodo maxSize: 2
        comentarios maxSize: 250, nullable: true
        enviado nullable:true
    }
}
