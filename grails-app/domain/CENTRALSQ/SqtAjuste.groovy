package CENTRALSQ

class SqtAjuste {
    String id
    Date fecha
    String comentarios
    int opcion
    Date fechaMod
    int enviado
    String referencia
    int numTransaccion

    SqtUsuario usuarioMod
    SqtTienda tienda
    SqtMovimiento movimiento
    SqtArea area
    SqtEstatus estatus
    SqtInventario inventario

    static hasMany = [ajustes:SqtDetalleAjuste]

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        comentarios maxSize: 250,nullable: true
        referencia maxSize: 32 ,nullable: true
        area nullable: true
        enviado nullable:true
        numTransaccion nullable: true
        inventario nullable: true
        opcion nullable: true
    }
}
